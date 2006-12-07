#ifndef _SCC_H
#define _SCC_H
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

#define SCC_PIDFILE		"/var/run/sccd.pid"
#define SCC_DEVICE		"/dev/tts/1"
#define SCC_SOCKET		"/dev/sccd"

#define SCC_PACKETLEN		8

#define SCC_RESETW1		0x23696f6d 
#define SCC_RESETW2		0x65676100
#define SCC_QUERYW1		0x00000000
#define SCC_QUERYW2		QUERYW1

/* word 1 defines */
#define SCC_RUN			0x62000000
#define SCC_STOP	  	0x63000000
#define SCC_ADVISESTOP		0x64000000
#define SCC_RESTART		0x65000000
#define SCC_ADVISERESTART	0x66000000
#define SCC_RESET		0x67000000
#define SCC_ADVISERESET		0x68000000
#define SCC_POWERMASK		0xFF000000

#define SCC_LEDOFF		0x00610000
#define SCC_LEDBLUE		0x00620000
#define SCC_LEDRED		0x00630000
#define SCC_LEDBLUEFLASH	0x00640000
#define SCC_LEDREDFLASH		0x00650000
#define SCC_LEDALTERNATE1	0x00660000
#define SCC_LEDALTERNATE3	0x00670000
#define SCC_LEDMASK		0x00FF0000

#define SCC_LEDRATEMASK		0x0000FF00
#define SCC_LEDRATESHIFT	8
#define SCC_LEDRATEHI		40		/* limit: where flash == on */
#define SCC_LEDRATELO		0		/* limit: where flash == off */
#define SCC_LEDIORATE		20

#define SCC_FANAUTO		0x00000061
#define SCC_FANON 		0x00000062
#define SCC_FANMASK		0x000000FF

/* word 2 defines */
#define SCC_FANTEMPONMASK	0xFF000000
#define SCC_FANTEMPONSHIFT	24
#define SCC_FANTEMPONHI		60		/* limit: board on fire 140F */

#define SCC_FANTEMPOFFMASK	0x00FF0000
#define SCC_FANTEMPOFFSHIFT	16
#define SCC_FANTEMPONLO		15		/* limit: never turn off 60F */
#define SCC_FANTEMPDIFF		2		/* limit: if the diff between 
						   hi and lo is < then this the
						   fan could rapidly sccillate
						   or never turn on */
#define SCC_HOST		0x00000700
#define SCC_CTLR00		0x00000000
#define SCC_CTLR12		0x00001200
#define SCC_IDMASK		0x0000FF00

#define SCC_CKSUMMASK		0x000000FF

#define SCC_POWERDEFAULT	SCC_RUN
#define SCC_LEDDEFAULT		SCC_LEDRED
#define SCC_LEDRATEDEFAULT	10
#define SCC_FANDEFAULT		SCC_FANAUTO
#define SCC_FANTEMPONDEFAULT	50
#define SCC_FANTEMPOFFDEFAULT	45

struct scc_cmd_table {
	char	*scc_cmd;
	int 	scc_cmdval;
};

typedef struct scc_cmd_table scc_cmd_t;

char scc_cksum(int *, int *);
int  scc_validate(int *, int *, int);
int  scc_setval(int *, int, int);
int  scc_setrate(int *, int, int, int);
int  scc_defaults(int *, int *);
int  scc_daemonize(int);
int  disk_activity(void);


#endif /* _SCC_H */

