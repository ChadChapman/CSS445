dave@RUPC:~$ apt-get install mariadb-server
E: Could not open lock file /var/lib/dpkg/lock - open (13: Permission denied)
E: Unable to lock the administration directory (/var/lib/dpkg/), are you root?
dave@RUPC:~$ sudo apt-get install mariadb-server
[sudo] password for dave: 
Reading package lists... Done
Building dependency tree       
Reading state information... Done
The following additional packages will be installed:
  libaio1 libdbd-mysql-perl libdbi-perl libmysqlclient20 libreadline5 libterm-readkey-perl
  mariadb-client-10.0 mariadb-client-core-10.0 mariadb-common mariadb-server-10.0
  mariadb-server-core-10.0 mysql-common
Suggested packages:
  libmldbm-perl libnet-daemon-perl libsql-statement-perl mariadb-test tinyca
The following NEW packages will be installed:
  libaio1 libdbd-mysql-perl libdbi-perl libmysqlclient20 libreadline5 libterm-readkey-perl
  mariadb-client-10.0 mariadb-client-core-10.0 mariadb-common mariadb-server mariadb-server-10.0
  mariadb-server-core-10.0 mysql-common
0 upgraded, 13 newly installed, 0 to remove and 13 not upgraded.
Need to get 16.3 MB of archives.
After this operation, 145 MB of additional disk space will be used.
Do you want to continue? [Y/n] Y
Get:1 http://us.archive.ubuntu.com/ubuntu xenial-updates/main amd64 mysql-common all 5.7.19-0ubuntu0.16.04.1 [15.7 kB]
Get:2 http://us.archive.ubuntu.com/ubuntu xenial-updates/universe amd64 mariadb-common all 10.0.31-0ubuntu0.16.04.2 [16.0 kB]
Get:3 http://us.archive.ubuntu.com/ubuntu xenial/main amd64 libdbi-perl amd64 1.634-1build1 [743 kB]
Get:4 http://us.archive.ubuntu.com/ubuntu xenial-updates/main amd64 libmysqlclient20 amd64 5.7.19-0ubuntu0.16.04.1 [809 kB]
Get:5 http://us.archive.ubuntu.com/ubuntu xenial-updates/universe amd64 libdbd-mysql-perl amd64 4.033-1ubuntu0.1 [84.3 kB]
Get:6 http://us.archive.ubuntu.com/ubuntu xenial/universe amd64 libterm-readkey-perl amd64 2.33-1build1 [27.2 kB]
Get:7 http://us.archive.ubuntu.com/ubuntu xenial/main amd64 libaio1 amd64 0.3.110-2 [6,356 B]      
Get:8 http://us.archive.ubuntu.com/ubuntu xenial/main amd64 libreadline5 amd64 5.2+dfsg-3build1 [99.5 kB]
Get:9 http://us.archive.ubuntu.com/ubuntu xenial-updates/universe amd64 mariadb-client-core-10.0 amd64 10.0.31-0ubuntu0.16.04.2 [4,375 kB]
Get:10 http://us.archive.ubuntu.com/ubuntu xenial-updates/universe amd64 mariadb-client-10.0 amd64 10.0.31-0ubuntu0.16.04.2 [1,178 kB]
Get:11 http://us.archive.ubuntu.com/ubuntu xenial-updates/universe amd64 mariadb-server-core-10.0 amd64 10.0.31-0ubuntu0.16.04.2 [4,789 kB]
Get:12 http://us.archive.ubuntu.com/ubuntu xenial-updates/universe amd64 mariadb-server-10.0 amd64 10.0.31-0ubuntu0.16.04.2 [4,156 kB]
Get:13 http://us.archive.ubuntu.com/ubuntu xenial-updates/universe amd64 mariadb-server all 10.0.31-0ubuntu0.16.04.2 [13.1 kB]
Fetched 16.3 MB in 55s (291 kB/s)                                                                  
Preconfiguring packages ...
Selecting previously unselected package mysql-common.
(Reading database ... 423810 files and directories currently installed.)
Preparing to unpack .../mysql-common_5.7.19-0ubuntu0.16.04.1_all.deb ...
Unpacking mysql-common (5.7.19-0ubuntu0.16.04.1) ...
Selecting previously unselected package mariadb-common.
Preparing to unpack .../mariadb-common_10.0.31-0ubuntu0.16.04.2_all.deb ...
Unpacking mariadb-common (10.0.31-0ubuntu0.16.04.2) ...
Selecting previously unselected package libdbi-perl.
Preparing to unpack .../libdbi-perl_1.634-1build1_amd64.deb ...
Unpacking libdbi-perl (1.634-1build1) ...
Selecting previously unselected package libmysqlclient20:amd64.
Preparing to unpack .../libmysqlclient20_5.7.19-0ubuntu0.16.04.1_amd64.deb ...
Unpacking libmysqlclient20:amd64 (5.7.19-0ubuntu0.16.04.1) ...
Selecting previously unselected package libdbd-mysql-perl.
Preparing to unpack .../libdbd-mysql-perl_4.033-1ubuntu0.1_amd64.deb ...
Unpacking libdbd-mysql-perl (4.033-1ubuntu0.1) ...
Selecting previously unselected package libterm-readkey-perl.
Preparing to unpack .../libterm-readkey-perl_2.33-1build1_amd64.deb ...
Unpacking libterm-readkey-perl (2.33-1build1) ...
Selecting previously unselected package libaio1:amd64.
Preparing to unpack .../libaio1_0.3.110-2_amd64.deb ...
Unpacking libaio1:amd64 (0.3.110-2) ...
Selecting previously unselected package libreadline5:amd64.
Preparing to unpack .../libreadline5_5.2+dfsg-3build1_amd64.deb ...
Unpacking libreadline5:amd64 (5.2+dfsg-3build1) ...
Selecting previously unselected package mariadb-client-core-10.0.
Preparing to unpack .../mariadb-client-core-10.0_10.0.31-0ubuntu0.16.04.2_amd64.deb ...
Unpacking mariadb-client-core-10.0 (10.0.31-0ubuntu0.16.04.2) ...
Selecting previously unselected package mariadb-client-10.0.
Preparing to unpack .../mariadb-client-10.0_10.0.31-0ubuntu0.16.04.2_amd64.deb ...
Unpacking mariadb-client-10.0 (10.0.31-0ubuntu0.16.04.2) ...
Selecting previously unselected package mariadb-server-core-10.0.
Preparing to unpack .../mariadb-server-core-10.0_10.0.31-0ubuntu0.16.04.2_amd64.deb ...
Unpacking mariadb-server-core-10.0 (10.0.31-0ubuntu0.16.04.2) ...
Processing triggers for man-db (2.7.5-1) ...
Processing triggers for libc-bin (2.23-0ubuntu9) ...
Processing triggers for menu (2.1.47ubuntu1) ...
Setting up mysql-common (5.7.19-0ubuntu0.16.04.1) ...
update-alternatives: using /etc/mysql/my.cnf.fallback to provide /etc/mysql/my.cnf (my.cnf) in auto mode
Setting up mariadb-common (10.0.31-0ubuntu0.16.04.2) ...
update-alternatives: using /etc/mysql/mariadb.cnf to provide /etc/mysql/my.cnf (my.cnf) in auto mode
Selecting previously unselected package mariadb-server-10.0.
(Reading database ... 424179 files and directories currently installed.)
Preparing to unpack .../mariadb-server-10.0_10.0.31-0ubuntu0.16.04.2_amd64.deb ...
/var/lib/mysql: found previous version 5.7
The file /var/lib/mysql/debian-5.7.flag indicated a
version that cannot automatically be upgraded. Therefore the
previous data directory will be renamed to /var/lib/mysql-5.7 and
a new data directory will be initialized at /var/lib/mysql.
Please manually export/import your data (e.g. with mysqldump) if needed.
Unpacking mariadb-server-10.0 (10.0.31-0ubuntu0.16.04.2) ...
Selecting previously unselected package mariadb-server.
Preparing to unpack .../mariadb-server_10.0.31-0ubuntu0.16.04.2_all.deb ...
Unpacking mariadb-server (10.0.31-0ubuntu0.16.04.2) ...
Processing triggers for systemd (229-4ubuntu19) ...
Processing triggers for ureadahead (0.100.0-19) ...
ureadahead will be reprofiled on next reboot
Processing triggers for man-db (2.7.5-1) ...
Setting up libdbi-perl (1.634-1build1) ...
Setting up libmysqlclient20:amd64 (5.7.19-0ubuntu0.16.04.1) ...
Setting up libdbd-mysql-perl (4.033-1ubuntu0.1) ...
Setting up libterm-readkey-perl (2.33-1build1) ...
Setting up libaio1:amd64 (0.3.110-2) ...
Setting up libreadline5:amd64 (5.2+dfsg-3build1) ...
Setting up mariadb-client-core-10.0 (10.0.31-0ubuntu0.16.04.2) ...
Setting up mariadb-client-10.0 (10.0.31-0ubuntu0.16.04.2) ...
Setting up mariadb-server-core-10.0 (10.0.31-0ubuntu0.16.04.2) ...
Setting up mariadb-server-10.0 (10.0.31-0ubuntu0.16.04.2) ...
Setting up mariadb-server (10.0.31-0ubuntu0.16.04.2) ...
Processing triggers for libc-bin (2.23-0ubuntu9) ...
Processing triggers for menu (2.1.47ubuntu1) ...
Processing triggers for systemd (229-4ubuntu19) ...
Processing triggers for ureadahead (0.100.0-19) ...
dave@RUPC:~$ top

top - 09:51:46 up 11:33,  1 user,  load average: 0.12, 0.33, 0.35
Tasks: 229 total,   1 running, 228 sleeping,   0 stopped,   0 zombie
%Cpu(s):  1.2 us,  0.2 sy,  0.0 ni, 98.5 id,  0.0 wa,  0.0 hi,  0.0 si,  0.0 st
KiB Mem :  5805000 total,  1597592 free,  1593832 used,  2613576 buff/cache
KiB Swap:  5980156 total,  5980156 free,        0 used.  3573688 avail Mem 

  PID USER      PR  NI    VIRT    RES    SHR S  %CPU %MEM     TIME+ COMMAND                         
 4883 dave      20   0 2475396 539048 143516 S   5.3  9.3   4:51.25 Web Content                     
18229 dave      20   0   41940   3904   3168 R   0.7  0.1   0:00.08 top                             
    7 root      20   0       0      0      0 S   0.3  0.0   0:02.47 rcu_sched                       
  576 root     -51   0       0      0      0 S   0.3  0.0   0:07.82 irq/30-iwlwifi                  
 2149 dave      20   0 1513652 201780  65284 S   0.3  3.5   1:35.43 compiz                          
 4952 dave      20   0  656020  44316  29012 S   0.3  0.8   0:02.36 gnome-terminal-                 
    1 root      20   0  185376   6068   4044 S   0.0  0.1   0:02.85 systemd                         
    2 root      20   0       0      0      0 S   0.0  0.0   0:00.01 kthreadd                        
    3 root      20   0       0      0      0 S   0.0  0.0   0:00.05 ksoftirqd/0                     
    5 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kworker/0:0H                    
    8 root      20   0       0      0      0 S   0.0  0.0   0:00.00 rcu_bh                          
    9 root      rt   0       0      0      0 S   0.0  0.0   0:00.15 migration/0                     
   10 root      rt   0       0      0      0 S   0.0  0.0   0:00.04 watchdog/0                      
   11 root      rt   0       0      0      0 S   0.0  0.0   0:00.04 watchdog/1                      
   12 root      rt   0       0      0      0 S   0.0  0.0   0:00.11 migration/1                     
   13 root      20   0       0      0      0 S   0.0  0.0   0:00.03 ksoftirqd/1                     
   15 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kworker/1:0H                    
   16 root      rt   0       0      0      0 S   0.0  0.0   0:00.04 watchdog/2                      
   17 root      rt   0       0      0      0 S   0.0  0.0   0:00.13 migration/2                     
   18 root      20   0       0      0      0 S   0.0  0.0   0:00.04 ksoftirqd/2                     
   20 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kworker/2:0H                    
   21 root      rt   0       0      0      0 S   0.0  0.0   0:00.04 watchdog/3                      
   22 root      rt   0       0      0      0 S   0.0  0.0   0:00.14 migration/3                     
   23 root      20   0       0      0      0 S   0.0  0.0   0:00.03 ksoftirqd/3                     
   25 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kworker/3:0H                    
   26 root      20   0       0      0      0 S   0.0  0.0   0:00.00 kdevtmpfs                       
   27 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 netns                           
   28 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 perf                            
   29 root      20   0       0      0      0 S   0.0  0.0   0:00.00 khungtaskd                      
   30 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 writeback                       
   31 root      25   5       0      0      0 S   0.0  0.0   0:00.00 ksmd                            
   32 root      39  19       0      0      0 S   0.0  0.0   0:00.67 khugepaged                      
   33 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 crypto                          
   34 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kintegrityd                     
   35 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 bioset                          
   36 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kblockd                         
   37 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 ata_sff                         
   38 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 md                              
dave@RUPC:~$ mariadb-server -v
mariadb-server: command not found
dave@RUPC:~$ systemctl start mariadb
Failed to start mariadb.service: Connection timed out
See system logs and 'systemctl status mariadb.service' for details.
dave@RUPC:~$ systemctl start mariadb
Failed to start mariadb.service: Unit mariadb.service not found.
dave@RUPC:~$ systemctl status mariadb
● mariadb.service
   Loaded: not-found (Reason: No such file or directory)
   Active: inactive (dead)
dave@RUPC:~$ systemctl start mariadb-server
Failed to start mariadb-server.service: Unit mariadb-server.service not found.
dave@RUPC:~$ sudo apt-get update
Get:1 https://apt.dockerproject.org/repo ubuntu-xenial InRelease [48.7 kB]
Get:2 http://security.ubuntu.com/ubuntu xenial-security InRelease [102 kB]      
Hit:3 http://us.archive.ubuntu.com/ubuntu xenial InRelease                                
Ign:1 https://apt.dockerproject.org/repo ubuntu-xenial InRelease                    
Get:4 http://us.archive.ubuntu.com/ubuntu xenial-updates InRelease [102 kB]        
Hit:5 https://cli-assets.heroku.com/branches/stable/apt ./ InRelease                       
Get:6 http://us.archive.ubuntu.com/ubuntu xenial-backports InRelease [102 kB]                  
Get:7 http://security.ubuntu.com/ubuntu xenial-security/main amd64 DEP-11 Metadata [60.2 kB]
Get:8 http://us.archive.ubuntu.com/ubuntu xenial-updates/main amd64 DEP-11 Metadata [305 kB]       
Get:9 http://security.ubuntu.com/ubuntu xenial-security/main DEP-11 64x64 Icons [57.6 kB]
Get:10 http://security.ubuntu.com/ubuntu xenial-security/universe amd64 DEP-11 Metadata [49.2 kB]
Get:11 http://security.ubuntu.com/ubuntu xenial-security/universe DEP-11 64x64 Icons [69.8 kB]     
Get:12 http://us.archive.ubuntu.com/ubuntu xenial-updates/main DEP-11 64x64 Icons [213 kB]         
Get:13 http://us.archive.ubuntu.com/ubuntu xenial-updates/universe amd64 DEP-11 Metadata [172 kB]  
Get:14 http://us.archive.ubuntu.com/ubuntu xenial-updates/universe DEP-11 64x64 Icons [227 kB]
Get:15 http://us.archive.ubuntu.com/ubuntu xenial-updates/multiverse amd64 DEP-11 Metadata [5,888 B]
Get:16 http://us.archive.ubuntu.com/ubuntu xenial-backports/main amd64 DEP-11 Metadata [3,328 B]
Get:17 http://us.archive.ubuntu.com/ubuntu xenial-backports/universe amd64 DEP-11 Metadata [4,584 B]
Fetched 1,522 kB in 1s (1,462 kB/s)                                          
Reading package lists... Done
W: GPG error: https://apt.dockerproject.org/repo ubuntu-xenial InRelease: The following signatures couldn't be verified because the public key is not available: NO_PUBKEY F76221572C52609D
W: The repository 'https://apt.dockerproject.org/repo ubuntu-xenial InRelease' is not signed.
N: Data from such a repository can't be authenticated and is therefore potentially dangerous to use.
N: See apt-secure(8) manpage for repository creation and user configuration details.
dave@RUPC:~$ sudo apt-get upgrade
Reading package lists... Done
Building dependency tree       
Reading state information... Done
Calculating upgrade... Done
The following packages have been kept back:
  libegl1-mesa libgbm1 libgl1-mesa-dri libgl1-mesa-dri:i386 libinput10 libmirclient9
  libwayland-egl1-mesa libxatracker2 linux-generic linux-headers-generic linux-image-extra-virtual
  linux-image-generic mesa-vdpau-drivers
0 upgraded, 0 newly installed, 0 to remove and 13 not upgraded.
dave@RUPC:~$ mysql -v
ERROR 1698 (28000): Access denied for user 'dave'@'localhost'
dave@RUPC:~$ sudo mysql -v
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 43
Server version: 10.0.31-MariaDB-0ubuntu0.16.04.2 Ubuntu 16.04

Copyright (c) 2000, 2017, Oracle, MariaDB Corporation Ab and others.

Reading history-file /home/dave/.mysql_history
Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> exit
Writing history-file /home/dave/.mysql_history
Bye
dave@RUPC:~$ mysql -u root
ERROR 1698 (28000): Access denied for user 'root'@'localhost'
dave@RUPC:~$ mysql -u root -p
Enter password: 
ERROR 1698 (28000): Access denied for user 'root'@'localhost'
dave@RUPC:~$ mysql
ERROR 1698 (28000): Access denied for user 'dave'@'localhost'
dave@RUPC:~$ mysql -v
ERROR 1698 (28000): Access denied for user 'dave'@'localhost'
dave@RUPC:~$ systemctl start mariadb-server
Failed to start mariadb-server.service: Unit mariadb-server.service not found.
dave@RUPC:~$ mysql -v
ERROR 1698 (28000): Access denied for user 'dave'@'localhost'
dave@RUPC:~$ sudo mysql -v
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 49
Server version: 10.0.31-MariaDB-0ubuntu0.16.04.2 Ubuntu 16.04

Copyright (c) 2000, 2017, Oracle, MariaDB Corporation Ab and others.

Reading history-file /home/dave/.mysql_history
Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> show database;
--------------
show database
--------------

ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'database' at line 1
MariaDB [(none)]> select user, host from mysql.user
    -> 
    -> exit
    -> root
    -> Ctrl-C -- exit!
Writing history-file /home/dave/.mysql_history
Aborted
dave@RUPC:~$ systemctl start mariadb-server
Failed to start mariadb-server.service: Unit mariadb-server.service not found.
dave@RUPC:~$ sudo mysql -v
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 50
Server version: 10.0.31-MariaDB-0ubuntu0.16.04.2 Ubuntu 16.04

Copyright (c) 2000, 2017, Oracle, MariaDB Corporation Ab and others.

Reading history-file /home/dave/.mysql_history
Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> CREATE USER 'chadtc'
    -> ;
--------------
CREATE USER 'chadtc'
--------------

Query OK, 0 rows affected (0.00 sec)

MariaDB [(none)]> CREATE USER 'chadtc'@'localhost';
--------------
CREATE USER 'chadtc'@'localhost'
--------------

Query OK, 0 rows affected (0.00 sec)

MariaDB [(none)]> SET PASSWORD FOR 'chadtc'@'localhost' = PASSWORD('dbpass');
--------------
SET PASSWORD FOR 'chadtc'@'localhost' = PASSWORD('dbpass')
--------------

Query OK, 0 rows affected (0.00 sec)

MariaDB [(none)]> GRANT ALL PRIVILEGES ON *.* TO 'chadtc'@'localhost' WITH GRANT OPTION;
--------------
GRANT ALL PRIVILEGES ON *.* TO 'chadtc'@'localhost' WITH GRANT OPTION
--------------

Query OK, 0 rows affected (0.00 sec)

MariaDB [(none)]> exit;
Writing history-file /home/dave/.mysql_history
Bye
dave@RUPC:~$ sudo mysql -u chadtc -p
Enter password: 
Welcome to the MariaDB monitor.  Commands end with ; or \g.
Your MariaDB connection id is 51
Server version: 10.0.31-MariaDB-0ubuntu0.16.04.2 Ubuntu 16.04

Copyright (c) 2000, 2017, Oracle, MariaDB Corporation Ab and others.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

MariaDB [(none)]> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
+--------------------+
3 rows in set (0.00 sec)

MariaDB [(none)]> create database hello;
Query OK, 1 row affected (0.00 sec)

MariaDB [(none)]> show databases;
+--------------------+
| Database           |
+--------------------+
| hello              |
| information_schema |
| mysql              |
| performance_schema |
+--------------------+
4 rows in set (0.00 sec)

MariaDB [(none)]> USE hello;
Database changed
MariaDB [hello]> show tables;
Empty set (0.00 sec)

MariaDB [hello]> DROP DATABASE hello;
Query OK, 0 rows affected (0.00 sec)

MariaDB [(none)]> CREATE DATABASE TCSS445;
Query OK, 1 row affected (0.00 sec)

MariaDB [(none)]> use TCSS445;
Database changed
MariaDB [TCSS445]> exit TCSS445;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'exit TCSS445' at line 1
MariaDB [TCSS445]> exit;
Bye
dave@RUPC:~$ ssh chadtc@cssgate.insttech.washington.edu
The authenticity of host 'cssgate.insttech.washington.edu (128.208.244.213)' can't be established.
ECDSA key fingerprint is SHA256:NtszPuRu3qGi5QIO1KIbG+SLxyE7qlHM5iw8d72MjQE.
Are you sure you want to continue connecting (yes/no)? yes
Warning: Permanently added 'cssgate.insttech.washington.edu' (ECDSA) to the list of known hosts.
chadtc@cssgate.insttech.washington.edu's password: 
Last login: Thu Jan  5 09:09:28 2017 from d-172-22-157-178.dhcp4.washington.edu

Use of this computer is subject to Institute of Technology policies:
                http://css.insttech.washington.edu/~lab/Policies/

a. For access to your INSTTECH home directory, please enter: 

   mounthome

   to mount your home directory from INSTTECH on ~/win

b. For access to your student classroom home directory -- the one you
use when logged into a classroom computer -- please refer to these directions:

   http://www.tacoma.uw.edu/information-technology/network-access

c. Your database and other special passwords are in ~/.pw

*** Please note that data stored locally on cssgate WILL BE DELETED at
*** the end of the quarter. This includes team accounts.
*** Please backup your projects at the end of the quarter.
[chadtc@cssgate2 ~]$ cd ~
[chadtc@cssgate2 ~]$ ls
svn
[chadtc@cssgate2 ~]$ ls -a
.  ..  .bash_history  .bash_logout  .bash_profile  .bashrc  .cache  .config  .pw  svn
[chadtc@cssgate2 ~]$ history
    1  mkdir svn
    2  svnadmin create svn/css305a16
    3  ls
    4  cd svn
    5  ls
    6  cd css305a16
    7  ls
    8  cd
    9  exit
   10  mkdir svn
   11  svnadmin create svn/css305a16
   12  cd svn/css305a16
   13  -l
   14  ls
   15  exit
   16  cd svn
   17  ls
   18  cd css305a16
   19  ls
   20  exit
   21  cd svn
   22  ls
   23  cd css305a16
   24  ls
   25  svnadmin create svn/css342w17
   26  cd svn/css342w17
   27  ls
   28  ls -a
   29  cd
   30  exit
   31  cd ~
   32  ls
   33  ls -a
   34  history
[chadtc@cssgate2 ~]$ 

