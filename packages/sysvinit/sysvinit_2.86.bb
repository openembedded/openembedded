DESCRIPTION = "System-V like init."
SECTION = "base"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
HOMEPAGE = "http://freshmeat.net/projects/sysvinit/"
PR = "r15"

# USE_VT and SERIAL_CONSOLE are generally defined by the MACHINE .conf.
# Set PACKAGE_ARCH appropriately.
PACKAGE_ARCH_${PN}-inittab = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "${PN}-inittab"

PACKAGES =+ "bootlogd ${PN}-inittab"
FILES_bootlogd = "/etc/init.d/bootlogd /etc/init.d/stop-bootlogd /etc/rc?.d/S*bootlogd /sbin/bootlogd"
FILES_${PN}-inittab = "${sysconfdir}/inittab"
CONFFILES_${PN}-inittab = "${sysconfdir}/inittab"

USE_VT ?= "1"

SRC_URI = "ftp://ftp.cistron.nl/pub/people/miquels/sysvinit/sysvinit-2.85.tar.gz \
	   file://sysvinit-2.86.patch;patch=1 \
	   file://install.patch;patch=1 \
           file://need \
           file://provide \
           file://inittab \
           file://rcS-default \
           file://rc \
           file://rcS \
	   file://bootlogd.init"
S = "${WORKDIR}/sysvinit-2.85"
B = "${S}/src"

inherit update-alternatives

ALTERNATIVE_NAME = "init"
ALTERNATIVE_LINK = "${base_sbindir}/init"
ALTERNATIVE_PATH = "${base_sbindir}/init.sysvinit"
ALTERNATIVE_PRIORITY = "50"

PACKAGES =+ "sysvinit-pidof sysvinit-sulogin"
FILES_${PN} += "${base_sbindir} ${base_bindir}"
FILES_sysvinit-pidof = "${base_bindir}/pidof"
FILES_sysvinit-sulogin = "${base_sbindir}/sulogin"

CFLAGS_prepend = "-D_GNU_SOURCE "
export LCRYPT = "-lcrypt"
EXTRA_OEMAKE += "'INSTALL=install' \
		 'bindir=${base_bindir}' \
		 'sbindir=${base_sbindir}' \
		 'usrbindir=${bindir}' \
		 'usrsbindir=${sbindir}' \
		 'includedir=${includedir}' \
		 'mandir=${mandir}'"

do_install () {
	oe_runmake 'ROOT=${D}' install
	install -d ${D}${sysconfdir} \
		   ${D}${sysconfdir}/default \
		   ${D}${sysconfdir}/init.d
	install -m 0644 ${WORKDIR}/inittab ${D}${sysconfdir}/inittab
	if [ ! -z "${SERIAL_CONSOLE}" ]; then
		echo "S:2345:respawn:${base_sbindir}/getty ${SERIAL_CONSOLE}" >> ${D}${sysconfdir}/inittab
	fi
	if [ "${USE_VT}" == "1" ]; then
		cat <<EOF >>${D}${sysconfdir}/inittab
# ${base_sbindir}/getty invocations for the runlevels.
#
# The "id" field MUST be the same as the last
# characters of the device (after "tty").
#
# Format:
#  <id>:<runlevels>:<action>:<process>
#
1:2345:respawn:${base_sbindir}/getty 38400 tty1
# 2:23:respawn:${base_sbindir}/getty 38400 tty2
# 3:23:respawn:${base_sbindir}/getty 38400 tty3
# 4:23:respawn:${base_sbindir}/getty 38400 tty4
EOF
	fi
	install -m 0644    ${WORKDIR}/rcS-default	${D}${sysconfdir}/default/rcS
	install -m 0755    ${WORKDIR}/rc		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/rcS		${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/bootlogd.init     ${D}${sysconfdir}/init.d/bootlogd
	ln -sf bootlogd ${D}${sysconfdir}/init.d/stop-bootlogd
	install -d ${D}${sysconfdir}/rcS.d
	ln -sf ../init.d/bootlogd ${D}${sysconfdir}/rcS.d/S07bootlogd
	for level in 2 3 4 5; do
		install -d ${D}${sysconfdir}/rc$level.d
		ln -s ../init.d/stop-bootlogd ${D}${sysconfdir}/rc$level.d/S99stop-bootlogd
	done
	mv                 ${D}${base_sbindir}/init               ${D}${base_sbindir}/init.sysvinit
}


do_install_append_ramses () {
	cat <<EOF >>${D}${sysconfdir}/inittab
# Bluetooth
#1:2345:respawn:${base_sbindir}/getty -L 115200 tts/1
# External serial port
4:2345:respawn:${base_sbindir}/getty -L 115200 tts/4
# Framebuffer
v1:2345:respawn:${base_sbindir}/getty -L 115200 vc/1
EOF
}
