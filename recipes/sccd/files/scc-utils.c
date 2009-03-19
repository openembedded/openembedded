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
#include <signal.h>
#include <sys/types.h>
#include <sys/ioctl.h>
#include <sys/select.h>
#include <sys/syslog.h>
#include <sys/resource.h>
#include <termios.h>

#include "scc.h"

int scc_die = 0;

char
scc_cksum(int *i, int *j)
{
	unsigned char s;
	unsigned char *b;

	b = (unsigned char *)i;
	s = b[0] + b[1] + b[2] + b[3];
	b = (unsigned char *)j;
	s = s + b[0] + b[1] + b[2];
 	s = (s & 0x7f);

	return((char)s);
}

int 
scc_validate(int *i, int *j, int verbose)
{
	int r, s;

	/* if (verbose) printf("Packet: [0x%08x 0x%08x]\n", *i, *j); */

	switch (*i & SCC_POWERMASK) {
	case SCC_RUN:
		if (verbose) printf("\tPower: run\n");
		break;
	case SCC_STOP:
		if (verbose) printf("\tPower: stop\n");
		break;
	case SCC_ADVISESTOP:
		if (verbose) printf("\tPower: advise stop\n");
		break;
	case SCC_RESTART:
		if (verbose) printf("\tPower: restart\n");
		break;
	case SCC_ADVISERESTART:
		if (verbose) printf("\tPower: advise restart\n");
		break;
	case SCC_RESET:
		if (verbose) printf("\tPower: reset\n");
		break;
	case SCC_ADVISERESET:
		if (verbose) printf("\tPower: advise reset\n");
		break;
	default:
		if (verbose) printf("validate: bad power 0x%08x\n", *i);
		return(-1);	
	}

	switch (*i & SCC_LEDMASK) {
	case SCC_LEDOFF:
		if (verbose) printf("\tLed: off\n");
		break;
	case SCC_LEDBLUE:
		if (verbose) printf("\tLed: blue\n");
		break;
	case SCC_LEDRED:
		if (verbose) printf("\tLed: red\n");
		break;
	case SCC_LEDBLUEFLASH:
		if (verbose) printf("\tLed: blue flash\n");
		break;
	case SCC_LEDREDFLASH:
		if (verbose) printf("\tLed: red flash\n");
		break;
	case SCC_LEDALTERNATE1:
		if (verbose) printf("\tLed: alternate1\n");
		break;
	case SCC_LEDALTERNATE3:
		if (verbose) printf("\tLed: alternate3\n");
		break;
	default:
		if (verbose) printf("validate: bad led value 0x%08x\n", *i);
		return(-1);	
	}	

	r = ((*i & SCC_LEDRATEMASK)  >> SCC_LEDRATESHIFT);

	if (verbose) {
		printf("\tLed Flash Rate: %d\n", r);
	}

	if (r >= SCC_LEDRATEHI) 
		printf("warning: led rate too high - led on (%d)\n", r);
	if (r <= SCC_LEDRATELO) 
		printf("warning: led rate too low - led off (%d)\n", r);


	switch (*i & SCC_FANMASK) {
	case SCC_FANAUTO:
		if (verbose) printf("\tFan: auto\n");
		break;
	case SCC_FANON:	
		if (verbose) printf("\tFan: on\n");
		break;
	default:
		if (verbose) printf("validate: bad fan value 0x%08x\n", *i);
		return(-1);	
	}

	r = ((*j & SCC_FANTEMPONMASK)  >> SCC_FANTEMPONSHIFT);
	s = ((*j & SCC_FANTEMPOFFMASK) >> SCC_FANTEMPOFFSHIFT);

	if (verbose) {
		printf("\tFan On  Temprature: %dC\n", r);
		printf("\tFan Off Temprature: %dC\n", s);
	}

	if (r >= SCC_FANTEMPONHI) 
		printf("warning: fan on temp too high - fan off (%dC)\n", r);
	if (s <= SCC_FANTEMPONLO) 
		printf("warning: fan on temp too low - fan on (%dC)\n", s);
	if ((r - s) < SCC_FANTEMPDIFF) {
		printf("warning: fan on/off temp too close or on < off \n");
		printf("warning:\tfan on (%dC) fan off (%dC) \n", r, s);
	}

	r = *j & SCC_IDMASK;
	if ((r != SCC_HOST) && 
	    (r != SCC_CTLR00) &&  
	    (r != SCC_CTLR12)) {
		printf("warning: bad id %08x\n", r);
	}	

	r = *j & SCC_CKSUMMASK; 
	if (r != scc_cksum(i, j)) {
		printf("warning: checksum incorrect (%02x != %02x)\n", 
		       r, scc_cksum(i, j));
	}
	return(0);	
}

int
scc_setval(int *i, int mask, int val)
{
	/* clear the field */
	*i = (*i & (mask ^ 0xffffffff));

	/* insert the field */
	*i = (*i ^ val);
	return(0);
}

int
scc_setrate(int *i, int mask, int shift, int val)
{
	/* Assumption: val is < field width */

	/* clear the field */
	*i = (*i & (mask ^ 0xffffffff));

	/* insert the field */
	*i = (*i ^ (val << shift));
	return(0);
}

int 
scc_defaults(int *i, int *j)
{
	scc_setval(i,  SCC_POWERMASK, SCC_POWERDEFAULT);
	scc_setval(i,  SCC_LEDMASK, SCC_LEDDEFAULT);	
	scc_setrate(i, SCC_LEDRATEMASK, SCC_LEDRATESHIFT, SCC_LEDRATEDEFAULT);
	scc_setval(i,  SCC_FANMASK, SCC_FANDEFAULT);

	scc_setrate(j, SCC_FANTEMPONMASK, 
		SCC_FANTEMPONSHIFT, SCC_FANTEMPONDEFAULT);
	scc_setrate(j, SCC_FANTEMPOFFMASK, 
		SCC_FANTEMPOFFSHIFT, SCC_FANTEMPOFFDEFAULT);
	return(0);
}

void 
scc_sighandler(int sig)
{
	/*
	 * Just catch quit and term and set die
	 */
	switch(sig) {
	case SIGQUIT:
	case SIGTERM:
		syslog(LOG_INFO, "Terminating");
		scc_die=1;
		break;
	}
}

int
scc_daemonize(int cores)
{
	int	fd, i;
	char	pidstr[20];
	pid_t	pid;

	struct rlimit limit[1] = {{ 0, 0 }};


	if (!cores) {
		/* 
		 * No corefiles please 
		 */
		if (getrlimit(RLIMIT_CORE, limit) == -1) {
			perror("getrlimit");
			return -1;
		}

		limit->rlim_cur = 0;

		if (setrlimit(RLIMIT_CORE, limit) != 0) {
			perror("setrlimit");
			return -1;
		}
	}
	
	/*
	 * Must be root
	 */
	if (getuid() != 0) {
		fprintf(stderr, "Must be root\n");
		return -1;
	}

	/* 
	 * If parent isn't init, make it init.
	 */
	if (getppid() != 1) {
    
		pid = fork();
		if (pid == -1) {
			return -1;
		}
		if (pid != 0) {
			exit(EXIT_SUCCESS);
		}

		setsid();

		/*
		 * ignore sig hup so that when our new padre exits
		 * the kinder won't exit
		 */
		signal(SIGHUP, SIG_IGN);

		pid = fork();
		if (pid == -1) {
			return -1;
		}
		if (pid != 0) {
			exit(EXIT_SUCCESS);
		}
	}

	/*
	 * Set working dir to root
	 */
	chdir("/");

	/*
	 * Make sure file creations are created with explicit perms
	 */
	umask(0);

	/*
	 * Close all FDs
	 */
	for (i = 0; i < sysconf(_SC_OPEN_MAX); i++) {
		close(i);
	}
	
	/* 
	 * set std in, out, err to /dev/null
	 */
	for (i = 0; i < 3; i++) {

		if ((fd = open("/dev/null", (i==0?O_RDONLY:O_WRONLY))) == -1) {
			perror("setting up stdin, stdout, stderr");
			return -1;
		}
		
		if (i != fd) {
			if (dup2(fd, i) == -1) {
				perror("setting up stdin, stdout, stderr");
				return -1;
			}
			close(fd);
		}
	}

	/*
	 * Open and lock the pid file. Ensures only one daemon
	 * Write our pid into the file 
	 */
	fd = open(SCC_PIDFILE, O_RDWR|O_CREAT, 0640);
	if (fd < 0) {
		return(-1);
		
	}
	
	if (lockf(fd, F_TLOCK, 0) < 0) {
		/* we are not alone */
		close(fd);
		return(-1);
	}

	sprintf(pidstr,"%-6d\n", getpid());
	write(fd, pidstr, strlen(pidstr)); 

	/*
	 * Open syslog
	 */
	openlog("sccd", LOG_PID, LOG_DAEMON);
	syslog(LOG_INFO, "Starting");

	/*
	 * Ignore some signals and handle others
	 */
	signal(SIGCHLD, SIG_IGN);
	signal(SIGTSTP, SIG_IGN);
	signal(SIGTTOU, SIG_IGN);
	signal(SIGTTIN, SIG_IGN);
	signal(SIGQUIT, scc_sighandler);
	signal(SIGTERM, scc_sighandler);

	return(0);
}


