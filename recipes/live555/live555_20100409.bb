# live555 OE build file
# Copyright (C) 2005, Koninklijke Philips Electronics NV.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "LIVE555 Streaming Media libraries"
HOMEPAGE = "http://live.com/"
LICENSE = "LGPL"
SECTION = "devel"

PR = "r0"

SRC_URI = "http://www.live555.com/liveMedia/public/live.2010.04.09.tar.gz \
           file://config.linux-cross"

S = "${WORKDIR}/live"
TARGET_CC_ARCH += "${LDFLAGS}"

do_configure() {
	cp ${WORKDIR}/config.linux-cross .
	./genMakefiles linux-cross
}

do_compile() {
	make
}

do_install() {
	install -d ${D}${includedir}/BasicUsageEnvironment
	install -d ${D}${includedir}/groupsock
	install -d ${D}${includedir}/liveMedia
	install -d ${D}${includedir}/UsageEnvironment
	install -d ${D}${libdir}
	cp -a ${S}/BasicUsageEnvironment/include/*.hh ${D}${includedir}/BasicUsageEnvironment/
	cp -a ${S}/groupsock/include/*.h ${D}${includedir}/groupsock/
	cp -a ${S}/groupsock/include/*.hh ${D}${includedir}/groupsock/
	cp -a ${S}/liveMedia/include/*.hh ${D}${includedir}/liveMedia/
	cp -a ${S}/UsageEnvironment/include/*.hh ${D}${includedir}/UsageEnvironment/
	# Find all the headers
	for i in $(find . -name "*.hh") $(find . -name "*.h") ; do
		install ${i} ${D}${includedir}
	done
	cp ${S}/*/*.a ${D}${libdir}
	install -d ${D}${bindir}
	for i in MPEG2TransportStreamIndexer openRTSP playSIP sapWatch testMPEG1or2AudioVideoToDarwin testMPEG1or2ProgramToTransportStream testMPEG1or2Splitter testMPEG1or2VideoReceiver testMPEG2TransportStreamTrickPlay testMPEG4VideoToDarwin testOnDemandRTSPServer testRelay testAMRAudioStreamer testDVVideoStreamer testMP3Receiver testMP3Streamer testMPEG1or2AudioVideoStreamer testMPEG1or2VideoStreamer testMPEG2TransportStreamer testMPEG4VideoStreamer testWAVAudioStreamer vobStreamer; do
		install -m 0755 ${S}/testProgs/${i} ${D}${bindir}/
	done
}

SRC_URI[md5sum] = "7f56f54c1c4697764c6e88282e353e81"
SRC_URI[sha256sum] = "e9539f59058cb885f28ac48cdce285f8a0fe567c4aa889c2ac3bd0638b007944"

PACKAGES =+ " live555-openrtsp live555-playsip"
FILES_${PN} = "${bindir}/sapWatch ${bindir}/testMPEG1or2AudioVideoToDarwin ${bindir}/testMPEG1or2ProgramToTransportStream ${bindir}/testMPEG1or2Splitter ${bindir}/testMPEG1or2VideoReceiver ${bindir}/testMPEG2TransportStreamTrickPlay ${bindir}/testMPEG4VideoToDarwin ${bindir}/testOnDemandRTSPServer ${bindir}/testRelay ${bindir}/testAMRAudioStreamer ${bindir}/testDVVideoStreamer ${bindir}/testMP3Receiver ${bindir}/testMP3Streamer ${bindir}/testMPEG1or2AudioVideoStreamer ${bindir}/testMPEG1or2VideoStreamer ${bindir}/testMPEG2TransportStreamer ${bindir}/testMPEG4VideoStreamer ${bindir}/testWAVAudioStreamer ${bindir}/vobStreamer ${bindir}/MPEG2TransportStreamIndexer"
FILES_live555-openrtsp = "${bindir}/openRTSP"
FILES_live555-playsip = "${bindir}/playSIP"
