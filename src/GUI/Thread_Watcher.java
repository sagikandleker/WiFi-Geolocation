package GUI;

import java.io.IOException;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import Main_App.Analayze_Files;
import Main_App.Write_2_CSV;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.ParseException;

/**
 * 
 *
 */
public class Thread_Watcher implements Runnable {

	@Override
	public void run() {
		try {

			WatchService watchService = GUI.directoryPath.getFileSystem().newWatchService();
			GUI.directoryPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE);

			//Start infinite loop to watch changes on the directory
			while (true) {

				WatchKey watchKey = watchService.take();

				// poll for file system events on the WatchKey
				for (final WatchEvent<?> event : watchKey.pollEvents()) {
					//Calling method
					takeActionOnChangeEvent(event);
				}

				//Break out of the loop if watch directory got deleted
				if (!watchKey.reset()) {
					watchKey.cancel();
					watchService.close();
			
					//Break out from the loop
					break;
				}
			}

		} catch (InterruptedException interruptedException) {
			System.out.println("Thread got interrupted:"+interruptedException);
			return;
		} catch (Exception exception) {
			exception.printStackTrace();
			return;
		}

	}

	private void takeActionOnChangeEvent(WatchEvent<?> event) {

		Kind<?> kind = event.kind();

		if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
			Write_2_CSV.All_Data_List.clear();

			try {
				Analayze_Files.getFiles(GUI_Wrapper.folder);
				GUI.textField.setText("Size of data: " + Write_2_CSV.All_Data_List.size());

			}
			catch (IOException | ParseException e) {

				e.printStackTrace();
			}
		} 

		else if (kind.equals(StandardWatchEventKinds.ENTRY_DELETE)) {

			Write_2_CSV.All_Data_List.clear();
			try {
				Analayze_Files.getFiles(GUI_Wrapper.folder);
				GUI.textField.setText("Size of data: " + Write_2_CSV.All_Data_List.size());

			} 
			catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		} 

		else if (kind.equals(StandardWatchEventKinds.ENTRY_MODIFY)) {

			Write_2_CSV.All_Data_List.clear();

			try {
				Analayze_Files.getFiles(GUI_Wrapper.folder);
				GUI.textField.setText("Size of data: " + Write_2_CSV.All_Data_List.size());

			} 
			catch (IOException e) {
				e.printStackTrace();
			} 
			catch (ParseException e) {
				e.printStackTrace();
			}

		}
	}
}

