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
#include <strings.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/ioctl.h>
#include <sys/select.h>
#include <sys/socket.h>
#include <sys/un.h>
#include <termios.h>

#include "scc.h"

char * prog;
int initialize = 0;
int verbose = 0;

scc_cmd_t powercmds[] = {
 	{	"a", 		0x61000000}, 
 	{	"run", 		SCC_RUN}, 	
	{	"off", 		SCC_STOP},
 	{	"advoff", 	SCC_ADVISESTOP}, 
	{	"restart", 	SCC_RESTART,},
 	{	"advrestart", 	SCC_ADVISERESTART}, 
	{	"reset", 	SCC_RESET,},
 	{	"advreset", 	SCC_ADVISERESET}, 
	{	"EOT",		-1}};

scc_cmd_t ledcmds[] =   {	
	{	"off", 		SCC_LEDOFF},
	{	"blue", 	SCC_LEDBLUE},
	{	"red", 		SCC_LEDRED},
	{	"blueflash", 	SCC_LEDBLUEFLASH},
	{	"redflash",	SCC_LEDREDFLASH},
	{	"alternate", 	SCC_LEDALTERNATE1},
	{	"alternate3", 	SCC_LEDALTERNATE3},
	{	"EOT",		-1}};

scc_cmd_t fancmds[]=   {	
	{	"auto", 	SCC_FANAUTO},
	{	"on", 		SCC_FANON},
	{	"EOT",		-1}};

void
usage(void)
{
	int i;
	scc_cmd_t *c;

	fprintf(stderr,	"Usage: %s OPTIONS\n", prog);
	fprintf(stderr,"%s controls the Iomega StorCenter's LED, fan and soft power.\n\n", prog);
	fprintf(stderr,"  -?\t\tthis message\n");
	fprintf(stderr,"  -v\t\tverbose, show all packets\n");
	fprintf(stderr,"  -d\t\tsend send directly, stop/restart only\n");
	fprintf(stderr,"\n  -p POWER\tcontrol soft power\n");
	fprintf(stderr,"\t\tPOWER=[");
	for (c = powercmds,i=0; c->scc_cmdval != -1; c++,i++) {
		if (i) fprintf(stderr,"|");
		fprintf(stderr,"%s", c->scc_cmd);
	}
	fprintf(stderr,"]\n\n");

	fprintf(stderr,"  -l LED\tcontrol LED state\n");
	fprintf(stderr,"\t\tLED=[");
	for (c = ledcmds,i=0; c->scc_cmdval != -1; c++,i++) {
		if (i) fprintf(stderr,"|");
		fprintf(stderr,"%s", c->scc_cmd);
	}
	fprintf(stderr,"]\n  -r RATE\tRate the LED flashes (0<=RATE<256)\n\n");


	fprintf(stderr,"  -f FAN\tcontrol fan operation\n");
	fprintf(stderr,"\t\tFAN=[");
	for (c = fancmds,i=0; c->scc_cmdval != -1; c++,i++) {
		if (i) fprintf(stderr,"|");
		fprintf(stderr,"%s", c->scc_cmd);
	}
	fprintf(stderr,"]\n  -h TEMP\tHot temp when FAN=auto should go on (0<=TEMP<256)\n");
	fprintf(stderr,"  -c TEMP\tCold temp when FAN=auto should go off (0<=TEMP<256)\n");
	
	(void)exit(2);
}

int
sendrecv(int fd, int *i, int *j)
{
	char			buf[8];
	int   		rc;
	fd_set		fds;
	struct timeval	sec = {1, 0};
	struct timespec	tenth_sec = {0, 100000000};


	/* build the buffer */
	*(int *)(buf) = *i;
	*(int *)(buf + 4) = *j;

	if (verbose) 
		printf("Send: [0x%08x 0x%08x]\n", *i, *j);

	if ((rc = write(fd, buf, 8)) != 8) {
		perror("write failed failed");
		return(-1);
	}
	
	/* Wait for data */
	FD_ZERO(&fds);
	FD_SET(fd, &fds);
	rc = select(1024, &fds, NULL, NULL, &sec);

	if (rc == -1) {
      	perror("select failed");
		return (-1);
	} else if (!rc) {
		perror("select timedout");
		return (-1);
	} 

	/* Consume it */
	if ((rc = read(fd, buf, 8)) != 8) {
		perror("read failed failed");
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
	int s, len;
	struct sockaddr_un remote;

	if ((s = socket(AF_UNIX, SOCK_STREAM, 0)) == -1) {
		return(-1);
        }

	remote.sun_family = AF_UNIX;
        strcpy(remote.sun_path, SCC_SOCKET);
        len = strlen(remote.sun_path) + sizeof(remote.sun_family);
        if (connect(s, (struct sockaddr *)&remote, len) == -1) {
		return(-1);
        }

	return(s);
}

int 
setup_cntlr(int *i, int *j)
{
	int	fd;
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
	*i = SCC_RESETW1;
	*j = SCC_RESETW2;
	scc_setval(i, SCC_IDMASK, SCC_HOST);
	scc_setval(j, SCC_CKSUMMASK, (int)scc_cksum(i, j));
	if (sendrecv(fd, i, j) < 0) 
		return(-1); 

	return(fd);
}

int 
main(int argc, char *argv[])
{

	int	devfd, w1, w2, h1, h2;
	int	coldtemp, hottemp, fancmd;
	int	ledrate, ledcmd;
	int	powercmd;
	int	direct;
	int	c;
	char	buf[SCC_PACKETLEN];
	scc_cmd_t	*ct;

	extern char	*optarg;
 	extern int	optind, opterr, optopt;

	prog = argv[0];
	fancmd = coldtemp = hottemp = -1;
	ledcmd = ledrate = -1;
	powercmd = -1;
	direct = 0;
	
	while ((c = getopt(argc, argv, "c:df:h:l:p:r:wv?")) != EOF) {
		switch (c) {
		case 'c':
			if (coldtemp != -1)  /* more than one -c arg */
				usage();

			coldtemp = atoi(optarg);
			if ((coldtemp > 255) || (coldtemp < 0))
				usage();
			break;
		case 'd':
			direct = 1;
			break;
		case 'f':
			if (fancmd != -1)  /* more than one -f arg */
				usage();

			for (ct = fancmds; ct->scc_cmdval != -1; ct++) {
				if (!strcmp(ct->scc_cmd, optarg)) {
					fancmd = ct->scc_cmdval;
				}
			}

			if (fancmd == -1)  /* Failed to find the req */
				usage();

			break;
		case 'h':
			if (hottemp != -1)  /* more than one -h arg */
				usage();

			hottemp = atoi(optarg);
			if ((hottemp > 255) || (hottemp < 0))
				usage();
			break;
		case 'l':
			if (ledcmd != -1)  /* more than one -l arg */
				usage();

			for (ct = ledcmds; ct->scc_cmdval != -1; ct++) {
				if (!strcmp(ct->scc_cmd, optarg)) {
					ledcmd = ct->scc_cmdval;
				}
			}

			if (ledcmd == -1)  /* Failed to find the req */
				usage();
			break;
		case 'p':
			if (powercmd != -1)  /* more than one -p arg */
				usage();

			for (ct = powercmds; ct->scc_cmdval != -1; ct++) {
				if (!strcmp(ct->scc_cmd, optarg)) {
					powercmd = ct->scc_cmdval;
				}
			}

			if (powercmd == -1)  /* Failed to find the req */
				usage();
			break;
		case 'r':
			if (ledrate != -1)  /* more than one -h arg */
				usage();

			ledrate = atoi(optarg);
			if ((ledrate > 255) || (ledrate < 0))
				usage();
			break;
		case 'v':
			verbose=1;
			break;
		case '?':
			usage();
			break;

		}
	}

	if (direct) {
		/* 
		 * Setup the cntlr connection 
		 */
		if ((devfd = setup_cntlr(&w1, &w2)) < 0)
			exit(1);
		scc_defaults(&w1, &w2);
	} else {
		/* 
		 * Setup the clnt connection, if we get an connection
		 * refused that means the daemon isn't listening.
		 * so go direct
		 */
		w1 = 0;
		w2 = 0;
		if ((devfd = setup_clnt()) < 0) {
			/* log it */
			if ((devfd = setup_cntlr(&w1, &w2)) < 0)
				exit(1);
			direct = 1;
			scc_defaults(&w1, &w2);
		}
	}
	
	/* 
	 * Direct (direct to the cntlr):
	 * w1 and w2 are setup with the default cntlr packet.
	 * Now lets poke the command line args into the packet.
	 *
	 * Nondirect (via the daemon):
	 * w1 and w2 are setup with nulls. The packet sent to the daemon 
	 * contains only the changes to the current state.
	 */
	if (powercmd != -1) 
		scc_setval(&w1, SCC_POWERMASK, powercmd);
	if (ledcmd != -1)
		scc_setval(&w1, SCC_LEDMASK, ledcmd);
	if (ledrate != -1)
		scc_setrate(&w1, SCC_LEDRATEMASK, SCC_LEDRATESHIFT, ledrate);
	if (fancmd != -1)
		scc_setval(&w1, SCC_FANMASK, fancmd);

	if (coldtemp != -1)
		scc_setrate(&w2, 
			    SCC_FANTEMPOFFMASK, SCC_FANTEMPOFFSHIFT, coldtemp);
	if (hottemp != -1)
		scc_setrate(&w2, 
			    SCC_FANTEMPONMASK, SCC_FANTEMPONSHIFT, hottemp);

	scc_setval(&w2, SCC_IDMASK, SCC_HOST);
	scc_setval(&w2, SCC_CKSUMMASK, (int)scc_cksum(&w1, &w2));


	if (direct) {
		if (verbose) {
			printf("New State: \n");
			scc_validate(&w1, &w2, verbose);
		}

		if (sendrecv(devfd, &w1, &w2) < 0) 
			exit(1); 
	} else {
		*(int *)(&buf[0]) = w1;
		*(int *)(&buf[4]) = w2;
		
		if (send(devfd, buf, SCC_PACKETLEN, 0) == -1) {
			perror("send");
			exit(1);
		}
	}

	close(devfd);
  	exit(0);
}
