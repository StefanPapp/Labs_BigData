
#Precondition: 
* In this directory we assume, we work in /workspace/src/um/um_academy_spark
* Spark binary is in the path environment


Lab Steps
Perform the following steps:
1.	View the hdfs dfs command
a.	With your AWS instance, open a Terminal window if you do not have one open already.

b.	From the command line, enter the following command to view the usage:
# hdfs dfs

c.	Notice the usage contains options for performing file system tasks in HDFS, like copying files from a local folder into HDFS, retrieving a file from HDFS, copying an moving files around, and making and removing directoires.  In this lab, you will perform these commands and many others, to help you become comfortable with working with the hdfs.


2.	Create a directory in HDFS
a.	Enter the following -ls command to view the contents of the user’s root directory in HDFS, which is /user/root:
# hdfs dfs –ls
 You do not have any files in /user/root yet, so no output is displayed 

b.	Run the -ls command, but this time specify the root HDFS folder:
# hdfs dfs –ls / 

The output should looking something like:

Important: Notice how adding the / in the –ls command caused the contents of the root folder to display, but leaving off the / showed the contents of /user/root, which is the user root’s home directory on hadoop.  If you do not provide the path for any hdfs dfs commands, the user’s home on hadoop is assumed.

c.	Enter the following command to create a directory named test in HDFS:
# hdfs dfs -mkdir test

d.	Verify the folder was created successfully
# hdfs dfs -ls
 

e.	Create a couple of subdirectories of test:
# hdfs dfs -mkdir test/test1
# hdfs dfs -mkdir –p test/test2/test3 

f.	Use the -ls command to view the contents of /user/root:
# hdfs dfs -ls 

Notice you only see the test directory.  To recursively view the contests of a folder, use -ls -R 
# hdfs dfs -ls -R 

The output should look like: 


3.	Delete a directory
a.	Delete the test2 folder (and recursively its subcontents) using the -rm -R command:
# hdfs dfs -rm -R test/test2 

b.	Now run the -ls -R command:
# hdfs dfs -ls -R 

The directory structure of the output should look like:

Note: Notice Hadoop create a .Trash folder for the root user and moved the deleted content there.  The .Trash folder empties automatically after a configured amount of time.
 
4.	Upload a file to the HDFS
a.	Now put a file into the test folder.
Change directories to /root/spark/data/
# cd /root/spark/data/

b.	Notice this folder contains a file named data.txt
# tail data.txt

c.	Run the following -put command to copy data.txt into the test folder in HDFS:
# hdfs dfs -put data.txt test/

d.	Verify the file is in the HDFS by listing the contents of test:
# hdfs dfs -ls test

The output should look like the following:


5.	Copy a file in the HDFS
a.	Now copy the data.txt file in test to another folder in HDFS using the -cp command:
# hdfs dfs -cp test/data.txt test/test1/data2.txt

b.	Verify the file is in both places by using the -ls -R command on test.  The output should look like the following:
# hdfs dfs -ls -R test


c.	Now delete the data2.txt file using the -rm command
# hdfs dfs -rm test/test1/data2.txt

d.	Verify the data2.txt file is in the .Trash folder

6.	View the contents of a file in the HDFS
a.	You can use the -cat command to view text files in the HDFS.
Enter the follwionig command to view the contest of data.txt
# hdfs dfs -cat test/data.txt

b.	You can also use the the -tail command to view the end of a file

7.	Getting a file from the HDFS
a.	See if you can figure out how to use the -get command to copy test/data.txt from the HDFS into your local /tmp folder.

8.	The getmerge command
a.	Put the file /root/spark/data/small_blocks.txt into the test folder in HDFS.  You should now have two files in test: data.txt and small_blocks.txt.

b.	Run the following -getmerge command:
# hdfs dfs -getmerge test /tmp/merged.txt

c.	What did the previous command do?  Open the file merged.txt to see what happened.

Result
You should now be comfortable with executing the various HDFS commands, including creating directories, putting files in the HDFS, copy files out of the HDFS, and deleting files and folders.
		

