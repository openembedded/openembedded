# pwlib .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)


DEFAULT_PREFERENCE = "-1"

HOMEPAGE="http://www.openh323.org/docs/PWLib/"
DESCRIPTION="Portable Text and GUI C/C++ Class Libarary."
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
LICENSE = "GPL"

SRC_URI="${DEBIAN_MIRROR}/main/p/${PN}/${PN}_${PV}.orig.tar.gz"
DEPENDS="openssl openldap"

inherit autotools

EXTRA_OECONF="--enable-ipv6 --disable-sasl --disable-sdl \
	      --disable-video --enable-plugins --with-plugins=oss"

S="${WORKDIR}/${PN}"

# Use openSSL

export OPENSSLFLAG=1
export OPENSSLDIR="${STAGING_LIBDIR}"
export OPENSSLLIBS="-lssl -lcrypt"
export MACHTYPE="x86"
export OSTYPE="linux"
export OSRELEASE="openembedded"

export CPLUS="${CXX}"

do_compile() {
	oe_runmake opt
}

HEADERS="ptbuildopts.h ptlib.h"

PTCLIB_HEADERS="ptclib/asnber.h ptclib/asner.h ptclib/asnper.h \
	        ptclib/asnxer.h ptclib/cypher.h ptclib/delaychan.h \
		ptclib/dtmf.h ptclib/ftp.h ptclib/html.h ptclib/http.h \
		ptclib/httpform.h ptclib/httpsvc.h ptclib/inetmail.h \
		ptclib/inetprot.h ptclib/ipacl.h ptclib/memfile.h \
		ptclib/mime.h ptclib/modem.h ptclib/pasn.h ptclib/pdns.h \
		ptclib/pils.h ptclib/pldap.h ptclib/psnmp.h ptclib/psoap.h \
		ptclib/pssl.h ptclib/pstun.h ptclib/ptts.h ptclib/pwavfile.h \
		ptclib/pxml.h ptclib/pxmlrpc.h ptclib/pxmlrpcs.h \
		ptclib/qchannel.h ptclib/random.h ptclib/shttpsvc.h \
		ptclib/socks.h ptclib/telnet.h ptclib/url.h ptclib/vsdl.h \
		ptclib/vxml.h"

PTLIB_HEADERS= "ptlib/MacMainIf.h ptlib/args.h ptlib/array.h \
		ptlib/channel.h ptlib/conchan.h ptlib/config.h \
		ptlib/contain.h ptlib/contain.inl ptlib/dict.h \
		ptlib/dynalink.h ptlib/ethsock.h ptlib/file.h \
		ptlib/filepath.h ptlib/icmpsock.h ptlib/indchan.h \
		ptlib/int64.h ptlib/ipdsock.h ptlib/ipsock.h ptlib/ipxsock.h \
		ptlib/lists.h ptlib/mail.h ptlib/mutex.h ptlib/notifier.h \
		ptlib/object.h ptlib/osutil.inl ptlib/pdirect.h \
		ptlib/pipechan.h ptlib/plugin.h ptlib/pluginmgr.h \
		ptlib/pprocess.h ptlib/pstring.h ptlib/ptime.h ptlib/qos.h \
		ptlib/remconn.h ptlib/safecoll.h ptlib/semaphor.h \
		ptlib/serchan.h ptlib/sfile.h ptlib/smartptr.h \
		ptlib/socket.h ptlib/sockets.h ptlib/sound.h \
		ptlib/spxsock.h ptlib/svcproc.h ptlib/syncpoint.h \
		ptlib/syncthrd.h ptlib/tcpsock.h ptlib/textfile.h \
		ptlib/thread.h ptlib/timeint.h ptlib/timer.h ptlib/udpsock.h \
		ptlib/vconvert.h ptlib/video.h ptlib/videoio.h \
		ptlib/videoio1394dc.h ptlib/unix/ptlib/channel.h \
		ptlib/unix/ptlib/conchan.h ptlib/unix/ptlib/config.h \
		ptlib/unix/ptlib/contain.h ptlib/unix/ptlib/dynalink.h \
		ptlib/unix/ptlib/ethsock.h ptlib/unix/ptlib/file.h \
		ptlib/unix/ptlib/filepath.h ptlib/unix/ptlib/icmpsock.h \
		ptlib/unix/ptlib/ipdsock.h ptlib/unix/ptlib/ipsock.h \
		ptlib/unix/ptlib/mutex.h ptlib/unix/ptlib/pdirect.h \
		ptlib/unix/ptlib/pipechan.h ptlib/unix/ptlib/pmachdep.h \
		ptlib/unix/ptlib/pprocess.h ptlib/unix/ptlib/ptime.h \
		ptlib/unix/ptlib/ptlib.inl ptlib/unix/ptlib/remconn.h \
		ptlib/unix/ptlib/semaphor.h ptlib/unix/ptlib/serchan.h \
		ptlib/unix/ptlib/sfile.h ptlib/unix/ptlib/socket.h \
		ptlib/unix/ptlib/sound.h ptlib/unix/ptlib/svcproc.h \
		ptlib/unix/ptlib/syncpoint.h ptlib/unix/ptlib/tcpsock.h \
		ptlib/unix/ptlib/textfile.h ptlib/unix/ptlib/thread.h \
		ptlib/unix/ptlib/timeint.h ptlib/unix/ptlib/timer.h \
		ptlib/unix/ptlib/udpsock.h ptlib/unix/ptlib/video.h \
		ptlib/unix/ptlib/videoio.h ptlib/unix/ptlib/videoio1394avc.h"

SHARE="make/common.mak make/defaultgui.mak \
       make/gui.mak make/lib.mak make/motif.mak \
       make/plugins.mak make/ptbuildopts.mak \
       make/ptlib.mak make/pwlib.mak make/qt.mak \
       make/unix.mak make/xlib.mak"

do_stage() {
	install -d ${STAGING_INCDIR}/ptlib/unix/ptlib
	install -d ${STAGING_INCDIR}/ptclib

	for file in ${HEADERS} ${PTCLIB_HEADERS} ${PTLIB_HEADERS}; do
		install -m 0644 ${S}/include/$file ${STAGING_INCDIR}/$file
	done

	install -d ${STAGING_LIBDIR}
	
	oe_libinstall -C lib libpt_linux_x86_r ${STAGING_LIBDIR}
	
	ln -sf ${STAGING_LIBDIR}/libpt_linux_x86_r.so ${STAGING_LIBDIR}/libpt.so

	install -d ${STAGING_DATADIR}/pwlib/make
	for file in ${SHARE}; do
		install -m 0644 ${S}/$file ${STAGING_DATADIR}/pwlib/$file
	done

	cat ${S}/make/ptlib-config | sed -e 's:LIBDIR=\"/usr/lib\":LIBDIR=\"${STAGING_LIBDIR}\":' -e 's:PWINSTDIR=\"/usr/share/pwlib\":PWINSTDIR=\"${STAGING_DATADIR}/pwlib\":' > ${STAGING_DATADIR}/pwlib/make/ptlib-config
	chmod 0755 ${STAGING_DATADIR}/pwlib/make/ptlib-config
}
