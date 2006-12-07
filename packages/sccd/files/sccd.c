/*
 * Copyright (c) 2006
 *	Protium Computing, Inc.  All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *	This product includes software developed by Protium Computing, Inc.
 * 4. The name of Protium Computing, Inc. may not be used to endorse or 
 *    promote products derived from this software without specific prior 
 *    written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY PROTIUM COMPUTING ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL PROTIUM COMPUTING BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
#include <stdio.h>
#include <fcntl.h>
#include <time.h>
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include <errno.h>
#include <utmp.h>
#include <sys/types.h>
#include <sys/ioctl.h>
#include <sys/select.h>
#include <sys/socket.h>
#include <sys/stat.h>
#include <sys/un.h>
#include <sys/syslog.h>
#include <sys/param.h>
#include <termios.h>

#include "scc.h"

#define HALT	"/sbin/halt"
#define REBOOT	"/sbin/reboot"

char * prog;
int verbose = 0;

extern int scc_die;

void
usage(void)
{
	fprintf(stderr,	"Usage: %s OPTIONS\n", prog);
	fprintf(stderr,
		"StorCenter Control Daemon manages the StorCenter's LED, fan and soft power.\n\n");
	fprintf(stderr,"  -?\t\tthis message\n");
	fprintf(stderr,"  -h\t\tthis message\n");
	fprintf(stderr,"  -c\t\tallow core files\n");
	fprintf(stderr,"  -f\t\trun in the foreground\n");
	fprintf(stderr,"  -v\t\tverbose, show all packets (must be used with -f)\n");
	(void)exit(2);
}

int
sendrecv(int fd, int *i, int *j)
{
	char		buf[8];
	int   		rc;
	fd_set		fds;
	struct timeval	sec = {1, 0};
	struct timespec	tenth_sec = {0, 100000};


	/* build the buffer */
	*(int *)(buf) = *i;
	*(int *)(buf + 4) = *j;

	if (verbose) 
		printf("Send: [0x%08x 0x%08x]\n", *i, *j);

	if ((rc = write(fd, buf, 8)) != 8) {
		syslog(LOG_ERR, "Write failed to controller");
		return(-1);
	}
	
	/* Wait for data */
	FD_ZERO(&fds);
	FD_SET(fd, &fds);
	rc = select(1024, &fds, NULL, NULL, &sec);

	if (rc == -1) {
		syslog(LOG_ERR, "Controller select failed");
		return (-1);
	} else if (!rc) {
		syslog(LOG_ERR, "Controller timeout");
		return (-1);
	} 

	/* Consume it */
	if ((rc = read(fd, buf, 8)) != 8) {
		syslog(LOG_ERR, "Read from controller failed");
		return(-1);
	}

	*i = *(int *)(buf);
	*j = *(int *)(buf + 4);

	if (verbose) 
		printf("Recv: [0x%08x 0x%08x]\n", *i, *j);

	/* Let it rest */
	nanosleep(&tenth_sec, NULL);

	return(0);
}
	
int 
setup_clnt()
{
	int s;
	struct sockaddr_un local;
	int len;

	if ((s = socket(AF_UNIX, SOCK_STREAM, 0)) == -1) {
            perror("socket");
            return(-1);
        }

        local.sun_family = AF_UNIX;
        strcpy(local.sun_path, SCC_SOCKET);
        unlink(local.sun_path);

        len = strlen(local.sun_path) + sizeof(local.sun_family);
        if (bind(s, (struct sockaddr *)&local, len) == -1) {
		perror("bind");
		close(s);
		return(-1);
        }

        if (listen(s, 5) == -1) {
		perror("listen");
		close(s);
		return(-1);
        }	

	/* Force the permission on the unix socket */
        if (chmod(SCC_SOCKET, (S_IWUSR | S_IRUSR)) < 0) {
                perror("chmod socket");
        }

	return(s);
}

int 
setup_cntlr()
{
	int	i, j, fd;
	char	*dev = SCC_DEVICE;
	struct termios	ti;

	/* setup the serial connection to 9600, 8n1 */
	if ((fd = open(dev, O_RDWR|O_NOCTTY)) < 0) {
		perror("Open failed");
		return(-1);
	}

	if (ioctl(fd, TCGETS, &ti) < 0) {
		perror("TCGETS failed");
		return(-1);
	}
	
	if (ioctl(fd, TCFLSH, 0) < 0) {
		perror("TCFLSH failed");
		return(-1);
	}	

	ti.c_iflag = IGNPAR;
	ti.c_oflag = 0;
	ti.c_cflag = (B9600 | CS8 | CREAD | CLOCAL);
	ti.c_lflag = 0;
	ti.c_line = N_TTY; 
	bzero(ti.c_cc, NCCS);
	ti.c_cc[VMIN] = 0x08;

	if (ioctl(fd, TCSETS, &ti) < 0) {
		perror("TCSETS failed");
		return(-1);
	}
	
	if (verbose) printf("Resetting microcontroller\n");
	i = SCC_RESETW1;
	j = SCC_RESETW2;
	scc_setval(&j, SCC_CKSUMMASK, (int)scc_cksum(&i, &j));
	if (sendrecv(fd, &i, &j) < 0) {
		return(-1); 
	}

	return(fd);
}

int
handle_clnt(int clnt, int *w1, int *w2)
{
	char	buf[SCC_PACKETLEN];
	int	s, t, i, j, *x, *y;
	struct sockaddr_un remote;

	t = sizeof(remote);
	s = accept(clnt, (struct sockaddr *)&remote, &t);
	if (s < 0) {
		syslog(LOG_ERR, "Unable to accept client");
		return(-1);
	}

	if (recv(s, buf, SCC_PACKETLEN, 0) != SCC_PACKETLEN) {
		return(-1);
	}
	close(s);

	x = (int *)&buf[0];
	y = (int *)&buf[4];

	/* 
	 * Clients only send fields they want enacted. This allows this daemon
	 * to keep the other values constant without informing the clients
	 * of the current setting. It allows the protocol to unidirectional.
	 * 
	 * Take the data from the client and add it to the current
	 * state then validate the resulting state.  If valid, return
	 * the new state. If not don't corrupt the existing state.
	 */
	i = *w1;
	j = *w2;

	if (*x & SCC_POWERMASK)
		scc_setval(&i, SCC_POWERMASK, (*x & SCC_POWERMASK));
	if (*x & SCC_LEDMASK)
		scc_setval(&i, SCC_LEDMASK,  (*x & SCC_LEDMASK));
	if (*x & SCC_LEDRATEMASK)
		scc_setval(&i, SCC_LEDRATEMASK, (*x & SCC_LEDRATEMASK));
	if (*x & SCC_FANMASK)
		scc_setval(&i, SCC_FANMASK, (*x & SCC_FANMASK));

	if (*y & SCC_FANTEMPONMASK)
		scc_setval(&j, SCC_FANTEMPONMASK, (*y & SCC_FANTEMPONMASK));
	if (*y & SCC_FANTEMPOFFMASK)
		scc_setval(&j, SCC_FANTEMPOFFMASK, (*y & SCC_FANTEMPOFFMASK));
	scc_setval(&j, SCC_IDMASK, SCC_HOST);
	scc_setval(&j, SCC_CKSUMMASK, (int)scc_cksum(&i, &j));

	if (scc_validate(&i, &j, verbose) < 0) {
		/* log it and return */
		return(-1);
	}

	/* 
	 * If we are here we got a good packet, return it.
	 */
	*w1 = i;
	*w2 = j;
	return(0);
}

#ifdef NOTUSED
char
runlevel()
{
        struct utmp *ut;
        time_t boot;

        /*
         * Find last boot time
         */
        time(&boot);
        boot -= (times(NULL) / HZ);

        setutent();
        while ((ut = getutent()) != NULL) {
                /*
                 * Find runlevel after our last boot
                 */
                if (ut->ut_type == RUN_LVL && ut->ut_time > boot)
			return(ut->ut_pid & 0xff);
        }
        endutent();

	return(0xff);
}
#endif 

int
work_loop(int cntlr, int clnt)
{
	
	int   		rc, w1, w2, c1, c2, saverate;
	int		shutdown_called = 0;
	pid_t		pid;
	fd_set		fds;
	struct timeval	tv;

	/* 
	 * If we are booting set to red flash and 
	 * wait for someone to change it.
	 * If we are already in runlevel 5 then set it to blue
	 */
	scc_defaults(&w1, &w2);
	scc_setval(&w1, SCC_LEDMASK, SCC_LEDREDFLASH);
	scc_setval(&w2, SCC_IDMASK, SCC_HOST);
	scc_setval(&w2, SCC_CKSUMMASK, (int)scc_cksum(&w1, &w2));

	if (verbose) {
		printf("New State: \n");
		scc_validate(&w1, &w2, verbose);
	}

	if (sendrecv(cntlr, &w1, &w2) < 0) { 
		/* log then carry on */
	}
	
	while (!scc_die) {
		/* 
		 * Wait for data. How long? Well detecting soft power
		 * events should happen fairly quickly, 1 second between
		 * probes should be enough, but detecting disk activity 
		 * probably needs to be a little faster. So we try 0.5s or 
		 * 500,000 micro seconds. If that steals too much CPU 
		 * then we backoff here.
		 */
		FD_ZERO(&fds);
		FD_SET(clnt, &fds);
		tv.tv_sec = 0;
		tv.tv_usec = 500000; 
		rc = select(1024, &fds, NULL, NULL, &tv);

		if (rc < 0) {
			/* Select failed try again */
			continue;
		} else if (rc) {
			/* Got a clnt request */
			if (handle_clnt(clnt, &w1, &w2) < 0) 
				continue;
		} else {
			/* timeout - just fallthrough to refresh ctlr */
		}

		/*
		 * Here's how we do blinking lights for disk activity.
		 * If there is disk activity and the LED is blue, then
		 * set the led to blueflash and the rate to io rate.
		 * Next time through if there is still activity, the 
		 * LED is unchanged. If no activity and the led is flashing
		 * blue then return it to solid blue and restore the rate.
		 */
		if (disk_activity()) {
			if ((w1 & SCC_LEDMASK) == SCC_LEDBLUE) {
				saverate = (w1 & SCC_LEDRATEMASK);
				scc_setval(&w1, SCC_LEDMASK, SCC_LEDBLUEFLASH);
				scc_setrate(&w1, SCC_LEDRATEMASK, 
					    SCC_LEDRATESHIFT, SCC_LEDIORATE);
			}
		} else {
			if ((w1 & SCC_LEDMASK) == SCC_LEDBLUEFLASH) {
				scc_setval(&w1, SCC_LEDMASK, SCC_LEDBLUE);
				scc_setval(&w1, SCC_LEDRATEMASK, saverate);
			}
		}
	
		/* 
		 * Getting here because of a timeout or client request
		 * in either case refresh the cntlr. Don't use w1 and w2
		 * to refresh, cause the daemon should not incorporate
		 * the controller's view of the state into the daemon's
		 * view. Only a client should alter w1 and w2.
		 */
		c1 = w1;
		c2 = w2;
		if (sendrecv(cntlr, &c1, &c2) < 0) { 
			continue;
		}
		
		/*
		 * Now examine the packet from the controller to see
		 * if action needs to be taken.
		 * If the power state is either: stop, restart or reset
		 * start shutting down the box. Once shutdown (reboot or halt)
		 * has beed call don't do it again.
		 */
		if (shutdown_called) 
			continue;

		switch (c1 & SCC_POWERMASK) {
		case SCC_STOP:
			/* exec halt */
			syslog(LOG_INFO, "Halt requested");
			if ((pid = fork()) == -1) {
				break;
			}

			if (pid == 0) {
				/* i am child */
				char *argv[] = {HALT, NULL};
				execv(HALT, argv);
				exit(EXIT_FAILURE);
			}

			shutdown_called = 1;
			break;

		case SCC_RESTART:
		case SCC_RESET:
			/* exec reboot */
			syslog(LOG_INFO, "Reboot requested");
			if ((pid = fork()) == -1) {
				break;
			}
			if (pid == 0) {
				/* i am child */
				char *argv[] = {REBOOT, NULL};
				execv(REBOOT, argv);
				exit(EXIT_FAILURE);
			}

			shutdown_called = 1;
			break;
			
		default:
			/* Nothing to do */
			break;
		}
	}
}

int 
main(int argc, char *argv[])
{

	int	cntlr, clnt, w1, w2;
	int	c, daemon, cores;

	struct stat	st;
	extern char	*optarg;
 	extern int	optind, opterr, optopt;

	prog = argv[0];
	daemon = 1;
	cores = 0;

	while ((c = getopt(argc, argv, "cfhv?")) != EOF) {
		switch (c) {
		case 'h':
			usage();
			break;
		case 'c':
			cores=1;
			break;
		case 'f':
			daemon=0;
			break;
		case 'v':
			verbose=1;
			break;
		case '?':
			usage();
			break;

		}
	}

	if (verbose && daemon) 
		usage();

	if (stat(HALT, &st) < 0) {
		perror("Couldn't find halt");
		exit(EXIT_FAILURE);
	}

	if (stat(REBOOT, &st) < 0) {
		perror("Couldn't find reboot");
		exit(EXIT_FAILURE);
	}
	
	if (daemon) {
		if (scc_daemonize(cores) < 0)
			exit(EXIT_FAILURE);
	} else {
		/*
		 * Open syslog
		 */
		openlog("sccd", LOG_PID, LOG_DAEMON);
		syslog(LOG_INFO, "Starting");
	}

	/* 
	 * Setup the controller connection
	 */
	if ((cntlr = setup_cntlr()) < 0)
		exit(EXIT_FAILURE);
	
	/* 
	 * Setup the client connection
	 */
	if ((clnt = setup_clnt()) < 0)
		exit(EXIT_FAILURE);
	
	work_loop(cntlr, clnt);

	close(cntlr);
	close(clnt);
	unlink(SCC_PIDFILE);
  	exit(EXIT_SUCCESS);
}

