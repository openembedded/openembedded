DESCRIPTION = "wireshark - a popular network protocol analyzer"
HOMEPAGE = "http://www.wireshark.org"
SECTION = "network"
LICENSE = "GPL"
DEPENDS = "perl-native gnutls libpcap pcre expat glib-2.0 libsmi gtk+"
EXTRA_OECONF = "--enable-usr-local=no --with-pcap=${STAGING_DIR_HOST}${layout_prefix} \
                --with-libsmi=${STAGING_DIR_HOST}${layout_prefix} --enable-tshark --enable-wireshark"

PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/wireshark/wireshark-${PV}.tar.bz2;name=src \
           file://ieee80215.4.patch;patch=1 \
           file://fix-configure.patch;patch=1 "
SRC_URI[src.md5sum] = "f3e0917ed393366bbf96c53b58cb0931"
SRC_URI[src.sha256sum]= "72c8178dd0614d963173d667d5ecb39bc7102453ea09da7ef3302daee7733f3c"

ARM_INSTRUCTION_SET = "arm"

PACKAGES += "libwireshark1-dev libwireshark1 libwireshark1-dbg"
FILES_libwireshark1 = "${libdir}/*.so*"
FILES_libwireshark1-dev += "${libdir}/*.la ${libdir}/*.a ${libdir}/*.so ${includedir}"
FILES_libwireshark1-dbg += "${libdir}/.debug"
LEAD_SONAME_libwireshark1 = "libwireshark.so.0"

PACKAGES += "${PN}-wireshark ${PN}-wireshark-dbg ${PN}-tshark ${PN}-tshark-dbg"
FILES_${PN}-wireshark = "${bindir}/wireshark"
FILES_${PN}-wireshark-dbg = "${bindir}/.debug/wireshark"
FILES_${PN}-tshark = "${bindir}/tshark"
FILES_${PN}-tshark-dbg = "${bindir}/.debug/tshark"
RDEPENDS_${PN}-tshark += "libsmi-mibs libsmi-pibs ${PN}-data"
RDEPENDS_${PN}-wireshark += "libsmi-mibs libsmi-pibs ${PN}-data"
RCONFLICTS_${PN}-tshark = "tshark wireshark (<1.0.5)"
RREPLACES_${PN}-tshark = "tshark wireshark (<1.0.5)"
RCONFLICTS_${PN}-wireshark = "tshark wireshark (<1.0.5)"
RREPLACES_${PN}-wireshark = "tshark wireshark (<1.0.5)"

PACKAGES += "${PN}-plugins-dbg ${PN}-plugins"
FILES_${PN}-plugins = "${libdir}/wireshark/plugins/${PV}/*.so ${libdir}/wireshark/plugins/${PV}/*.la"
FILES_${PN}-plugins-dbg += "${libdir}/wireshark/plugins/${PV}/.debug"

PACKAGES += "${PN}-data"
FILES_${PN}-data = "${datadir}/wireshark"

PACKAGES += "${PN}-utils ${PN}-utils-dbg"
FILES_${PN}-utils = "${bindir}/text2pcap ${bindir}/dumpcap \
                     ${bindir}/rawshark ${bindir}/editcap  \
                     ${bindir}/mergecap ${bindir}/idl2wrs  \
                     ${bindir}/dftest ${bindir}/capinfos   \
                     ${bindir}/randpkt"
FILES_${PN}-utils-dbg = "${bindir}/.debug"

FILES_${PN} = ""
FILES_${PN}-dev = ""
FILES_${PN}-dbg = ""
ALLOW_EMPTY_${PN} = "1"
RDEPENDS_${PN} = "${PN}-tshark ${PN}-wireshark ${PN}-plugins ${PN}-data"
RCONFLICTS_${PN} = "tshark wireshark (<1.0.5)"
RREPLACES_${PN} = "tshark wireshark (<1.0.5)"

inherit autotools

do_compile_prepend() {
         find . -type f -name Makefile \
                -exec sed -e 's@-I/usr/include @@g' \
                          -e 's@-I$(includedir)@@g' \
                          -e 's@-I/usr/local/include @@g' \
                          -e "s@-I${includedir} @@g" -i '{}' ';'

         oe_runmake -C tools/lemon CC="${BUILD_CC} ${BUILD_CFLAGS}" \
         CC_FOR_BUILD="${BUILD_CC} ${BUILD_CFLAGS}" LDFLAGS="${BUILD_LDFLAGS}"
}

