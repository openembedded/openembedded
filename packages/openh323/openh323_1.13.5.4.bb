# openh323 .bb build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see /COPYING)

HOMEPAGE="http://www.openh323.org/"
DESCRIPTION="Open Soure ITU-T H.323 teleconferencing protocol implementation."
MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
LICENSE = "GPL"

SRC_URI="http://http.us.debian.org/debian/pool/main/o/${PN}/${PN}_${PV}.orig.tar.gz \
	file://fixes.patch;patch=1"

S="${WORKDIR}/${PN}"
DEPENDS="pwlib openssl"

export PWLIBDIR=${STAGING_DATADIR}/pwlib
export PTLIB_CONFIG=${STAGING_DATADIR}/pwlib/make/ptlib-config
export OPENH323DIR=${S}

export OPENSSLFLAG=1
export OPENSSLDIR=${STAGING_LIBDIR}
export OPENSSLLIBS="-lssl -lcrypt"
export MACHTYPE="x86"
export OSTYPE="linux"
export OSRELEASE="openembedded"
export CPLUS="${CXX}"

inherit autotools
EXTRA_OECONF="--enable-localspeex"

FILES_${PN} = "/usr/lib"
FILES_${PN}-dev += "/usr/share"

do_compile() {
	oe_runmake opt
}

HEADERS="QTIoctl.h channels.h codecs.h cu30codec.h dynacodec.h ffh263codec.h g7231codec.h g726codec.h g729codec.h gccpdu.h gkclient.h gkserver.h gsmcodec.h guid.h h225.h h225ras.h h235.h h235auth.h h245.h h248.h h261codec.h h263codec.h h323.h h323annexg.h h323caps.h h323con.h h323ep.h h323neg.h h323pdu.h h323rtp.h h323t120.h h323t38.h h323trans.h h4501.h h45010.h h45011.h h4502.h h4504.h h4505.h h4506.h h4507.h h4508.h h4509.h h450pdu.h h501.h h501pdu.h ilbccodec.h ixjDefs.h ixjidb.h ixjlid.h jitter.h lid.h lpc10codec.h mcspdu.h mediafmt.h mscodecs.h opalvxml.h opalwavfile.h openh323buildopts.h openh323buildopts.h.in peclient.h q931.h rfc2833.h rtp.h rtp2wav.h speexcodec.h svcctrl.h t120proto.h t38.h t38proto.h transports.h vblasterlid.h vpblid.h x224.h x880.h"

do_stage() {
	install -d ${STAGING_LIBDIR} ${STAGING_INCDIR}/openh323
	for file in ${HEADERS}; do
		install -m 0644 include/$file ${STAGING_INCDIR}/openh323
	done

	oe_libinstall -C lib libh323_linux_x86_r ${STAGING_LIBDIR}
	ln -sf ${STAGING_LIBDIR}/libh323_linux_x86_r.so ${STAGING_LIBDIR}/libopenh323.so

	install -d ${STAGING_DATADIR}/openh323
	install -m 0644 openh323u.mak ${STAGING_DATADIR}/openh323
}
