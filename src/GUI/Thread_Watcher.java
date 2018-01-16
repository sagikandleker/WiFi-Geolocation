package GUI;

import java.io.IOException;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.ParseException;

import Data_base.ConnectionMySQL;
import Memory.Data_Structures;

/**
 * Thread Watcher on folder to change.
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

	/**
	 * If the folder had been changed the function take action and update the Data structure.
	 * @param event
	 */
	private void takeActionOnChangeEvent(WatchEvent<?> event) {

		Kind<?> kind = event.kind();

		if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) {
			Data_Structures.All_Data.clear();

			try {
				if(Data_Structures.Sql_flag == true) {
				Reading.Folder_Path.getFiles(GUI_Wrapper.folder);
				ConnectionMySQL.start();
				GUI.textField.setText("Size of data: " + Data_Structures.Sql_Data.size());
				}
				else {
					
					Reading.Folder_Path.getFiles(GUI_Wrapper.folder);
					GUI.textField.setText("Size of data: " + Data_Structures.All_Data.size());
				}
				
				
				

			}
			catch (IOException | ParseException e) {

				e.printStackTrace();
			}
		} 

		else if (kind.equals(StandardWatchEventKinds.ENTRY_DELETE)) {

			Data_Structures.All_Data.clear();
			try {
				if(Data_Structures.Sql_flag == true) {
					Reading.Folder_Path.getFiles(GUI_Wrapper.folder);
					ConnectionMySQL.start();
					GUI.textField.setText("Size of data: " + Data_Structures.Sql_Data.size());
					}
					else {
						
						Reading.Folder_Path.getFiles(GUI_Wrapper.folder);
						GUI.textField.setText("Size of data: " + Data_Structures.All_Data.size());
					}

			} 
			catch (IOException | ParseException e) {
				e.printStackTrace();
			}
		} 

		else if (kind.equals(StandardWatchEventKinds.ENTRY_MODIFY)) {

			Data_Structures.All_Data.clear();

			try {
				if(Data_Structures.Sql_flag == true) {
					Reading.Folder_Path.getFiles(GUI_Wrapper.folder);
					ConnectionMySQL.start();
					GUI.textField.setText("Size of data: " + Data_Structures.Sql_Data.size());
					}
					else {
						
						Reading.Folder_Path.getFiles(GUI_Wrapper.folder);
						GUI.textField.setText("Size of data: " + Data_Structures.All_Data.size());
					}

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

