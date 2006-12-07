#
# Copyright (c) 2006
#	Protium Computing, Inc.  All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
# 1. Redistributions of source code must retain the above copyright
#    notice, this list of conditions and the following disclaimer.
# 2. Redistributions in binary form must reproduce the above copyright
#    notice, this list of conditions and the following disclaimer in the
#    documentation and/or other materials provided with the distribution.
# 3. All advertising materials mentioning features or use of this software
#    must display the following acknowledgement:
#	This product includes software developed by Protium Computing, Inc.
# 4. The name of Protium Computing, Inc. may not be used to endorse or 
#    promote products derived from this software without specific prior 
#    written permission.
#
# THIS SOFTWARE IS PROVIDED BY PROTIUM COMPUTING ``AS IS'' AND
# ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
# IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
# ARE DISCLAIMED.  IN NO EVENT SHALL PROTIUM COMPUTING BE LIABLE
# FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
# DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
# OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
# HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
# LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
# OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
# SUCH DAMAGE.
#
TARGETS=sccd scc

all:	$(TARGETS)

sccd:	scc-disk.o scc-utils.o sccd.o
	$(CC) $(CFLAGS)   -o sccd scc-utils.o scc-disk.o sccd.o

scc:	scc-utils.o scc.o
	$(CC) $(CFLAGS)   -o scc scc-utils.o scc.o

install: $(TARGETS)
	install -d           $(DESTDIR)/sbin
	install -m 755 sccd  $(DESTDIR)/sbin/sccd
	install -m 755 scc   $(DESTDIR)/sbin/scc
	install -d           $(DESTDIR)/etc/init.d
	install -m 755 init-sccd   $(DESTDIR)/etc/init.d/sccd
	install -d           $(DESTDIR)/usr/share/man/man1
	install -m 644 scc.1 $(DESTDIR)/usr/share/man/man1/scc.1

clean:
	rm -f $(TARGETS) *.o core
