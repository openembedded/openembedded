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
#include <unistd.h>
#include <stdlib.h>
#include <string.h>
#include <strings.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/un.h>
#include <sys/syslog.h>
#include <sys/param.h>

struct watch_table {
	char 	*wt_path;
	int	wt_status;
	int	wt_reads;
	int	wt_writes;
#define WT_INVALID	0
#define WT_VALID	1
#define WT_CHECK	2
} iowt[] = { 
	{ "/sys/block/hda/stat", 	WT_CHECK,	0,	0},
	{ "/sys/block/hdb/stat", 	WT_CHECK,	0,	0},
	{ "/sys/block/hdc/stat", 	WT_CHECK,	0,	0},
	{ "/sys/block/hdd/stat", 	WT_CHECK,	0,	0},
	{ NULL, WT_INVALID, -1, -1}
};

/* 
 * disk_activity() returns back the total number of read and writes done 
 * by the devices listed in the io watch table since the last call to 
 * disk_activity.  The number of reads and writes are determined by 
 * opening and reading each of the valid files listed in the io watch 
 * table.The number of reads and writes are stored in the io watch table so 
 * that the next call to this routine can compare the current number of read 
 * and writes to those stored in the io watch table. The difference for 
 * each device is summed in the activity variable.  The routine lazy 
 * evaluates the existance of the devices in the table. 
 *
 * For the storcenter, we are only concerned with internal drives. 
 *
 * The wt_path element must point at a diskstat file in the sysfs filesystem.  
 * File format can be found at: /usr/src/linux/Documentation/iostats.txt
 * For this routine:
 *	nr, nw - number read and writes
 *	nmr, nmw - number of merged reads and writes
 *	nsr, nsw - number of the sectors read and written
 *	tr, tw - time spent reading and writing
 *	nio - raw number of ios 
 * 	tio, wtio - time spent and weighted time spent doing io
 */
int
disk_activity()
{
	int	activity = 0;
	char	mesg[256];
	int	rc, nr, nmr, nsr, tr, nw, nmw, nsw, tw, nio, tio, wtio;
	FILE	*f;

	struct stat		st;
	struct watch_table	*w;

	for (w = iowt; w->wt_path; w++) {
		/*
		 * If status ids set to check, do the lazy existence 
		 * evaluation. If stat fails set to invalid. Don't 
		 * worry about perms here. 
		 */
		if ((w->wt_status == WT_CHECK) && 
		    (stat(w->wt_path, &st) < 0)) {
			sprintf(mesg, "%s not available", w->wt_path);
			syslog(LOG_INFO, mesg);
			w->wt_status = WT_INVALID;
		}

		/*
		 * Short circuit the loop if invalid.
		 */
		if (w->wt_status == WT_INVALID) 
			continue;

		/*
		 * If it can't be opened rdonly, set to invalid
		 */
		if ((f = fopen(w->wt_path, "r")) < 0) {
			sprintf(mesg, "Unable to open %s, no longer watching",
				w->wt_path);
			syslog(LOG_INFO, mesg);
			w->wt_status = WT_INVALID;
			continue;
		}

		rc = fscanf(f, "%d %d %d %d %d %d %d %d %d %d %d", 
		       &nr, &nmr, &nsr, &tr,
		       &nw, &nmw, &nsw, &tw,
		       &nio, &tio, &wtio);

		fclose(f);

		if (rc != 11) {
			sprintf(mesg, "Unable to read %s", w->wt_path);
			syslog(LOG_INFO, mesg);
			continue;
		}

		/*
		 * If we haven't seen any activity on this device before
		 * then just save the values and go on. This, although
		 * not strictly necessary, prevents the initial call to 
		 * disk_activity returning back the base set io activity.
		 * Remember it takes two calls to get a true difference.
		 */
		if ((w->wt_reads == 0) && (w->wt_writes == 0)) {
			w->wt_reads  = nr;
			w->wt_writes = nw;
			continue;
		}

		activity += (nr - w->wt_reads);
		activity += (nw - w->wt_writes);

		w->wt_reads  = nr;
		w->wt_writes = nw;

		/*
		   printf("%s: %d %d %d %d %d %d %d %d %d %d %d\n",
		       w->wt_path,
		       nr, nmr, nsr, tr,
		       nw, nmw, nsw, tw,
		       nio, tio, wtio);
		*/
	}

	return(activity);
}
