/*
 * icmpquery.c - send and receive ICMP queries for address mask
 *               and current time.
 *
 * Version 1.0.3
 *
 * Copyright 1998, 1999, 2000  David G. Andersen <angio@pobox.com>
 *                                        <danderse@cs.utah.edu>
 *                                        http://www.angio.net/
 *
 * All rights reserved.
 * This information is subject to change without notice and does not
 * represent a commitment on the part of David G. Andersen.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of David G. Andersen may not
 *    be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  
 * IN NO EVENT SHALL DAVID G. ANDERSEN BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 *
 *
 * Verified to work on:
 *    FreeBSD (2.x, 3.x)
 *    Linux 2.0.x, 2.2.0-pre1
 *    NetBSD 1.3
 *
 * Should work on Solaris and other platforms with BSD-ish stacks.
 *
 * If you compile it somewhere else, or it doesn't work somewhere,
 * please let me know.
 *
 * Compilation:  gcc icmpquery.c -o icmpquery
 *
 * One usage note:  In order to receive accurate time information,
 *                  the time on your computer must be correct; the
 *                  ICMP timestamp reply is a relative time figure.
 */


/* Some portions of this code are taken from FreeBSD's ping source.
 * Those portions are subject to the BSD copyright, which is appended
 * at the end of this file.  Namely, in_cksum.
 */

#include <time.h>
#include <sys/time.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <netinet/in.h>
#include <netinet/in_systm.h>
#include <netinet/ip.h>
#include <netinet/ip_icmp.h>
#include <errno.h>
#include <string.h>
#include <signal.h>
#include <arpa/inet.h>

u_short in_cksum(u_short *addr, int len);

/*
 * We perform lookups on the hosts, and then store them in a chain
 * here.
 */

struct hostdesc {
	char *hostname;
	struct in_addr hostaddr;
	struct hostdesc *next;
};

struct hostdesc *hostnames;
struct hostdesc *hosttail;

void resolv_from(char *hostfrom, struct in_addr *fromaddr)
{
	struct hostent *hp;
	if (hostfrom == NULL) {
		fromaddr->s_addr = 0;
		return;
	}
	
	if ((hp = gethostbyname(hostfrom)) == NULL) {
		if ((fromaddr->s_addr = inet_addr(hostfrom)) == -1) {
			fprintf(stderr, "could not resolve from address\n");
			exit(0);
		}
	} else {
		bcopy(hp->h_addr_list[0], &fromaddr->s_addr, hp->h_length);
	}
}

/*
 * Set up the list of hosts.  Return the count.
 */

int makehosts(char **hostlist)
{
	int i;
	struct hostent *hp;
	struct in_addr tmpaddr;
	int hostcount = 0;
	
	for (i = 0; hostlist[i]; i++) {
#ifdef DEBUG
		printf("Resolving %s\n", hostlist[i]);
#endif
		if ((hp = gethostbyname(hostlist[i])) == NULL) {
			if ((tmpaddr.s_addr = inet_addr(hostlist[i]))) {
				/* Could not resolve it.  Skip it. */
				fprintf(stderr, "%s: unknown host\n",
					hostlist[i]);
				continue;
			}
		} else {
			bcopy(hp->h_addr_list[0],
			      &tmpaddr.s_addr, hp->h_length);
		}

		/* The host has been resolved.  Put it in the chain */
		/* We want to stick it on the end. */
		if (hostnames == NULL) {
			hostnames = (struct hostdesc *)
				malloc(sizeof(*hostnames));
			if (hostnames == NULL) {
				perror("hostnames malloc failed");
				exit(-1);
			}
			hosttail = hostnames;
		} else {
			hosttail->next = (struct hostdesc *)
				malloc(sizeof(*hostnames));
			if (hosttail->next == NULL) {
				perror("hosttail->next malloc failed");
				exit(-1);
			}
			hosttail = hosttail->next;
		}
		hosttail->hostname = strdup(hostlist[i]);
		if (hosttail->hostname == NULL) {
			perror("strdup failed");
			exit(-1);
		}
		hosttail->hostaddr = tmpaddr;
		hosttail->next = NULL;
		hostcount++;
	}
	return hostcount;
}

void usage(char *prog)
{
   fprintf(stderr,
	   "%s  <-query> [-B] [-f fromhost] [-d delay] [-T time] targets\n"
	   "    where <query> is one of:\n"
	   "        -t : icmp timestamp request (default)\n"
	   "        -m : icmp address mask request\n"
	   "    The delay is in microseconds to sleep between packets.\n"
	   "    targets is a list of hostnames or addresses\n"
	   "    -T specifies the number of seconds to wait for a host to\n"
	   "       respond.  The default is 5.\n"
	   "    -B specifies \'broadcast\' mode.  icmpquery will wait\n"
	   "       for timeout seconds and print all responses.\n"
	   "    If you're on a modem, you may wish to use a larger -d and -T\n"
	   ,prog);
}

/*
 * Set up a packet.  Returns the length of the ICMP portion.
 */

int initpacket(char *buf, int querytype, struct in_addr fromaddr)
{
   struct ip *ip = (struct ip *)buf;
   struct icmp *icmp = (struct icmp *)(ip + 1);

   /* things we customize */
   int icmplen = 0;

   ip->ip_src = fromaddr;	/* if 0,  have kernel fill in */
   ip->ip_v = 4;		/* Always use ipv4 for now */
   ip->ip_hl = sizeof *ip >> 2;
   ip->ip_tos = 0;
   ip->ip_id = htons(4321);
   ip->ip_ttl = 255;
   ip->ip_p = 1;
   ip->ip_sum = 0;                 /* kernel fills in */

   icmp->icmp_seq = 1;
   icmp->icmp_cksum = 0;
   icmp->icmp_type = querytype;
   icmp->icmp_code = 0;

   switch(querytype) {
   case ICMP_TSTAMP:
	   gettimeofday( (struct timeval *)(icmp+8), NULL);
	   bzero( icmp+12, 8);
	   icmplen = 20;
	   break;
   case ICMP_MASKREQ:
	   *((char *)(icmp+8)) = 255;
	   icmplen = 12;
	   break;
   default:
	   fprintf(stderr, "eek: unknown query type\n");
	   exit(0);
   }
   ip->ip_len = sizeof(struct ip) + icmplen;
   return icmplen;
}
   
void sendpings(int s, int querytype, struct hostdesc *head, int delay,
	       struct in_addr fromaddr)
     
{
	char buf[1500];
	struct ip *ip = (struct ip *)buf;
	struct icmp *icmp = (struct icmp *)(ip + 1);
	struct sockaddr_in dst;
	int icmplen;

	bzero(buf, 1500);
	icmplen = initpacket(buf, querytype, fromaddr);
	dst.sin_family = AF_INET;

	while (head != NULL) {
#ifdef DEBUG
		printf("pinging %s\n", head->hostname);
#endif
		ip->ip_dst.s_addr = head->hostaddr.s_addr;
		dst.sin_addr = head->hostaddr;
		icmp->icmp_cksum = 0;
		icmp->icmp_cksum = in_cksum((u_short *)icmp, icmplen);
		if (sendto(s, buf, ip->ip_len, 0,
			   (struct sockaddr *)&dst,
			   sizeof(dst)) < 0) {
			perror("sendto");
		}
		if (delay)
			usleep(delay);
		/* Don't flood the pipeline..kind of arbitrary */
		head = head->next;
	}
}

void myexit(int whatsig)
{
	exit(0);
}

/*
 * Listen for 'hostcount' pings, print out the information, and
 * then exit.
 */

void recvpings(int s, int querytype, struct hostdesc *head, int hostcount,
	       int broadcast)
{
	char buf[1500];
	struct ip *ip = (struct ip *)buf;
	struct icmp *icmp;
	int err = 0;
	long int fromlen = 0;
	int hlen;
	struct timeval tv;
	struct tm *tmtime;
	int recvd = 0;
	char *hostto;
	char hostbuf[128], timebuf[128];
	struct hostdesc *foundhost;
	unsigned long int icmptime, icmpmask;

	gettimeofday(&tv, NULL);

	while (recvd < hostcount) {
		if ((err = recvfrom(s, buf, sizeof buf, 0, NULL,
				    (int *)&fromlen)) < 0)
		{
			perror("icmpquery:  recvfrom");
		}
      
		hlen = ip->ip_hl << 2;
		icmp = (struct icmp *)(buf + hlen);

		/* Find the host */
		hostto = 0;
		for (foundhost = head; foundhost != NULL;
		     foundhost = foundhost->next) {
			if (foundhost->hostaddr.s_addr == ip->ip_src.s_addr) {
				hostto = foundhost->hostname;
				break;
			}
		}

		if (!hostto) {
			sprintf(hostbuf, "unknown (%s)",
				inet_ntoa(ip->ip_src));
			hostto = hostbuf;
		}
		
		/* For time */
		switch(icmp->icmp_type) {
		case ICMP_TSTAMPREPLY:
			icmptime = ntohl(icmp->icmp_ttime);
			 /* ms since midnight. yuch. */
			tv.tv_sec -= tv.tv_sec%(24*60*60);
			tv.tv_sec += (icmptime/1000);
			tv.tv_usec = (icmptime%1000);
			tmtime = localtime(&tv.tv_sec);
			strftime(timebuf, 128, "%H:%M:%S", tmtime);
			printf("%-40.40s:  %s\n", hostto, timebuf);
			break;

		case ICMP_MASKREPLY:
			icmpmask = ntohl(icmp->icmp_dun.id_mask);
			printf("%-40.40s:  0x%lX\n", hostto, icmpmask);
			break;

		default:
			printf("Unknown ICMP message received (type %d)\n",
			       icmp->icmp_type);
			break;
		}
		if (!broadcast)
			recvd++;
	}
}

int
main(int argc, char **argv)
{
   int s;

   char *progname;
   extern char *optarg;         /* getopt variable declarations */
   char *hostfrom = NULL;
   extern int optind;
   extern int optopt;
   extern int opterr;
   char ch;                     /* Holds the getopt result */
   int on = 1;
   int hostcount;
   int delay = 0;
   int querytype = ICMP_TSTAMP;
   struct in_addr fromaddr;
   int timeout = 5;  /* Default to 5 seconds */
   int broadcast = 0; /* Should we wait for all responses? */

   fromaddr.s_addr = 0;

   progname = argv[0];

   while ((ch = getopt(argc, argv, "Btmf:d:T:")) != EOF) 
      switch(ch)
      {
      case 'B':
	      broadcast = 1;
	      break;
      case 'd':
	      delay = (int) strtol(optarg, NULL, 10);
	      break;
      case 't': /* timestamp request */
	      querytype = ICMP_TSTAMP;
	      break;
      case 'm': /* address mask request */
	      querytype = ICMP_MASKREQ;
	      break;
      case 'f':
	      hostfrom = optarg;
	      resolv_from(hostfrom, &fromaddr);
	      break;
      case 'T':
	      timeout = (int) strtol(optarg, NULL, 10);
	      break;
      default:
	      usage(progname);
	      exit(-1);
      }
   argc -= optind;
   argv += optind;

   if (!argv[0] || !strlen(argv[0])) 
   {
      usage(progname);
      exit(-1);
   }

   hostcount = makehosts(argv);

   if ((s = socket(AF_INET, SOCK_RAW, IPPROTO_ICMP)) < 0) {
      perror("socket");
      exit(1);
   }
   if (setsockopt(s, IPPROTO_IP, IP_HDRINCL, &on, sizeof(on)) < 0) {
      perror("IP_HDRINCL");
      exit(1);
   }

   signal(SIGALRM, myexit);
   alarm(timeout);
   sendpings(s, querytype, hostnames, delay, fromaddr);
   recvpings(s, querytype, hostnames, hostcount, broadcast);
   exit(0);
}
   
/*
 * in_cksum --
 *	Checksum routine for Internet Protocol family headers (C Version)
 *      From FreeBSD's ping.c
 */

u_short
in_cksum(addr, len)
	u_short *addr;
	int len;
{
	register int nleft = len;
	register u_short *w = addr;
	register int sum = 0;
	u_short answer = 0;

	/*
	 * Our algorithm is simple, using a 32 bit accumulator (sum), we add
	 * sequential 16 bit words to it, and at the end, fold back all the
	 * carry bits from the top 16 bits into the lower 16 bits.
	 */
	while (nleft > 1)  {
		sum += *w++;
		nleft -= 2;
	}

	/* mop up an odd byte, if necessary */
	if (nleft == 1) {
		*(u_char *)(&answer) = *(u_char *)w ;
		sum += answer;
	}

	/* add back carry outs from top 16 bits to low 16 bits */
	sum = (sum >> 16) + (sum & 0xffff);	/* add hi 16 to low 16 */
	sum += (sum >> 16);			/* add carry */
	answer = ~sum;				/* truncate to 16 bits */
	return(answer);
}


/*
 * Copyright (c) 1989, 1993
 *      The Regents of the University of California.  All rights reserved.
 *
 * This code is derived from software contributed to Berkeley by
 * Mike Muuss.
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
 *      This product includes software developed by the University of
 *      California, Berkeley and its contributors.
 * 4. Neither the name of the University nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */
