DESCRIPTION = "Chrony time synchronization"
LICENSE = "GPL"
CHRONY_REV="fe2cfe1faee10b3d972f79fe30b5c8ac09469409"
DEPENDS += "readline"
REDEPENDS += "readline"

PV = "1.23+gitr${CHRONY_REV}"

SRC_URI = "git://git.tuxfamily.org/gitroot/chrony/chrony.git;protocol=git;rev=${CHRONY_REV} \
	file://chrony_start.sh \
	file://chrony_stop.sh \
	file://init \
	file://chrony.conf \
	file://chrony.keys \
"
S = "${WORKDIR}/git"

do_configure() {
	${S}/configure
}

do_compile() {
	unset CPPFLAGS
	oe_runmake
}

do_install_append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0644 ${WORKDIR}/chrony.conf ${D}${sysconfdir}/
    install -m 0644 ${WORKDIR}/chrony.keys ${D}${sysconfdir}/
    install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/chronyd
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/chrony_start.sh ${D}${bindir}
    install -m 0755 ${WORKDIR}/chrony_stop.sh ${D}${bindir}
}