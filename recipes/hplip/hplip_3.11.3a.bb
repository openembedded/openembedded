DESCRIPTION = "HP Linux Imaging and Printing"
LICENSE = "GPL, MIT, BSD"

DEPENDS = "cups net-snmp"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz \
	"
inherit autotools

EXTRA_OECONF = ' \
                BUILD_SYS="" HOST_SYS="" \
                --enable-hpijs-install \
                --enable-gui-build \
                --enable-pp-build \
                --enable-policy-kit \
                --disable-scan-build \
                --enable-foomatic-ppd-install \
                --enable-foomatic-drv-install \
                --enable-udev-acl-rules \
               '

# needed by python checks in configure
EXTRA_OEMAKE = 'BUILD_SYS="" HOST_SYS=""'

do_configure_append() {
	sed -i -e 's:PYTHONINCLUDEDIR = ${STAGING_INCDIR_NATIVE}/python2.6:PYTHONINCLUDEDIR = ${STAGING_INCDIR}/python2.6:g' Makefile
}

do_install_prepend() {
	sed -i -e s:SYSFS:ATTRS:g data/rules/55-hpmud.rules
	sed -i -e s:SYSFS:ATTRS:g data/rules/56-hpmud_support.rules
}

PACKAGES += "${PN}-ppd ${PN}-cups ${PN}-backend ${PN}-filter"
RDEPENDS_${PN} += "net-snmp-client python-syslog python-pprint python-compression python-shell python-xml python-unixadmin python-html python-resource python-terminal"

# need to snag the debug file or OE will fail on backend package
FILES_${PN}-dbg += "\
     ${libdir}/cups/backend/.debug \
     ${libdir}/python2.6/site-packages/.debug \
     ${libdir}/cups/filter/.debug "

FILES_${PN}-ppd = "\
     ${datadir}/ppd"

FILES_${PN}-cups = "\
     ${datadir}/cups"

FILES_${PN}-backend = "\
     ${libdir}/cups/backend"

FILES_${PN}-filter = "\
     ${libdir}/cups/filter"

FILES_${PN} += "\
     ${libdir}/python2.6/site-packages \
     ${datadir}/hal/fdi/preprobe/10osvendor \
    "

SRC_URI[md5sum] = "967e095bec457b4acc858774d673f884"
SRC_URI[sha256sum] = "ec51d275a91fcb54e9191c0f1475d5c742e659ca94f97f0be2d507d1091be569"

