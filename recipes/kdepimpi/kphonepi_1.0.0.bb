DESCRIPTION = "Kphone/Pi is a 'Voice Over Internet' phone which uses the Session Initiation Protocol (SIP)."
SECTION = "opie/applications"
PRIORITY = "optional"
LICENSE = "GPL"
HOMEPAGE = "http://www.pi-sync.net/html/kp_pi.html"
DEPENDS ="openssl"

SRC_URI = "${SOURCEFORGE_MIRROR}/kdepimpi/kphone_pi_${PV}.tar.gz"

S = "${WORKDIR}/kphone_pi"

inherit palmtop

EXTRA_QMAKEVARS_POST += "QMAKE_UIC=${STAGING_BINDIR_NATIVE}/uic QMAKE_MOC=${STAGING_BINDIR_NATIVE}/moc QMAKE_RPATH=-Wl,-rpath-link, OBJECTS_DIR=obj/ MOC_DIR=moc/ TARGET=${S}/dest/kppi HEADERS-=kphone/qptrlisth HEADERS+=kphone/qptrlist.h LIBS+=-lstdc++"
QMAKE_PROFILES= "kphone_piE.pro"

do_configure_prepend() {
	mkdir ${S}/dest/
}

do_install() {
    install -d ${D}${palmtopdir}/bin \
               ${D}${palmtopdir}/apps/Applications \
               ${D}${palmtopdir}/pics/kphone/

    install -m 0644 ${S}/bin/kdepim/kphone/*.png ${D}${palmtopdir}/pics/kphone/
    install -m 0644 ${S}/kphone.desktop ${D}${palmtopdir}/apps/Applications/

    install -m 0755 ${S}/dest/kppi ${D}${palmtopdir}/bin/kppi
}

SRC_URI[md5sum] = "90d1517db39d4e3f7934af566ea18fca"
SRC_URI[sha256sum] = "a1b86dc2ef641bc644ff5a206b5e2d3a61dacf58c2c489e0669ba1d71d0534a0"
