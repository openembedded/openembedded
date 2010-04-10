DESCRIPTION = "xmms plugin for the tremos integer vorbis decoder"
SECTION = "x11/multimedia"
LICENSE = "GPL"
DEPENDS = "xmms tremor"
SRC_URI = "http://mirror1.pdaxrom.org/source/src/xmms-tremor-1.0.tar.bz2"

inherit autotools

FILES_${PN} = "${libdir}/xmms/Input/libxmmstremor.so"
FILES_${PN}-dbg += "${libdir}/xmms/Input/.debug/libxmmstremor.so"


SRC_URI[md5sum] = "998d2a399bd0fb9a2bcde6d5bd2443d4"
SRC_URI[sha256sum] = "66514764e9aa0168af22a5b4334e9882fbb0b87285ee2055c1daceb3a2214315"
