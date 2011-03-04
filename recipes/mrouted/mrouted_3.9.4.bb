DESCRIPTION = "DVMRP multicast routing daemon"
HOMEPAGE = "http://troglobit.com/mrouted.shtml"
SECTION = "network"
LICENSE = "BSD"
DEPENDS = "bison-native"

SRC_URI = "ftp://ftp.vmlinux.org/pub/People/jocke/mrouted/mrouted-${PV}.tar.bz2"
SRC_URI[md5sum] = "688b74fc42919d588f262e6b3c9c6d4c"
SRC_URI[sha256sum] = "c697549b2e506a380575f7adb67e87288ef2295b97241b3a1aeb0e88b827a3e1"

EXTRA_OEMAKE = " \
        datadir=${datadir} \
        mandir=${mandir} \
        prefix=${prefix} \
        sysconfdir=${sysconfdir} \
        DESTDIR=${D} \
"

do_install() {
        oe_runmake install
}
