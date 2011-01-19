DESCRIPTION = "Eibd provides an interface to the EIB / KNX bus"
HOMEPAGE = "http://www.auto.tuwien.ac.at/~mkoegler/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = " pthsem libxml2"
DEPENDS_append_libc-uclibc = " argp-standalone "
INC_PR = "r2"

SRC_URI += " file://eibd "

inherit autotools update-rc.d

EXTRA_OECONF = " --with-pth=yes --without-pth-test \
                 --enable-onlyeibd \
                 --enable-pei16 \
                 --enable-ft12 \
                 --enable-tpuart \
                 --enable-pei16s \
                 --enable-tpuarts \
                 --enable-usb \
                 --enable-eibnetip \
                 --enable-eibnetiptunnel \
                 --enable-eibnetipserver \
                 "

do_install_prepend() {
        install -d ${D}${sysconfdir}/default/
        install -d ${D}${sysconfdir}/init.d/
        install -m 0755 ${WORKDIR}/eibd ${D}${sysconfdir}/init.d/eibd
}

PACKAGES = "eibd-client-sources libeibclient eibd-server eibd-server-dbg \
            eibd-clients-dbg eibd-clients libeibclient-dev libeibclient-dbg"

FILES_eibd-server = "${bindir}/eibnetsearch ${bindir}/findknxusb \
                     ${bindir}/eibd ${bindir}/bcuaddrtab \
                     ${bindir}/eibnetdescribe ${bindir}/bcuread \
                     ${sysconfdir}/init.d/eibd  "
FILES_eibd-server-dbg = "${bindir}/.debug/eibd"
FILES_eibd-client-sources = "${datadir}/bcusdk/*"
FILES_eibd-clients = "${bindir}/*"
FILES_eibd-clients-dbg = "${bindir}/.debug"
FILES_libeibclient = "\
                     ${libdir}/lib*${SOLIBS} \
                     ${base_libdir}/*${SOLIBS} "
FILES_libeibclient-dev = "\
                     ${includedir} \
                     ${libdir}/*.la \
                     ${libdir}/*.a "
FILES_libeibclient-dbg = "${libexecdir}/.debug ${libdir}/.debug \
                          ${base_libdir}/.debug "

DESCRIPTION_eibd-clients = "Simple example programs to perform management tasks on a EIB system."
DESCRIPTION_libeibclient = "A client library written in C to access the EIB bus over eibd."
DESCRIPTION_libeibclient-dev = "A client library written in C to access the EIB bus over eibd."
DESCRIPTION_eibd-server = "eibd is a daemon which supports connection to an EIB (KNX) network over various \
interfaces. It provides its services over TCP/IP or Unix domain sockets. \
It can also act as an EIBnet/IP server."

INITSCRIPT_PACKAGES = "eibd-server"
INITSCRIPT_NAME = "eibd"
INITSCRIPT_PARAMS = "defaults 20"
