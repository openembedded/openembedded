DESCRIPTION = "System-V like init."
SECTION = "base"
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
HOMEPAGE = "http://freshmeat.net/projects/sysvinit/"
PR = "r8"

# USE_VT and SERIAL_CONSOLE are generally defined by the MACHINE .conf.
# Set PACKAGE_ARCH appropriately.
PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES =+ "bootlogd"
FILES_bootlogd = "/etc/init.d/bootlogd /etc/rcS.d/*bootlogd /sbin/bootlogd"

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
ALTERNATIVE_LINK = "/sbin/init"
ALTERNATIVE_PATH = "/sbin/init.sysvinit"
ALTERNATIVE_PRIORITY = "50"

PACKAGES =+ "sysvinit-pidof sysvinit-sulogin"
FILES_${PN} += "/sbin /bin"
FILES_sysvinit-pidof = "/bin/pidof"
FILES_sysvinit-sulogin = "/sbin/sulogin"

CFLAGS_prepend = "-D_GNU_SOURCE "
export LCRYPT = "-lcrypt"
EXTRA_OEMAKE += "'INSTALL=install' \
		 'bindir=/bin' \
		 'sbindir=/sbin' \
		 'usrbindir=${bindir}' \
		 'usrsbindir=${sbindir}' \
		 'includedir=${includedir}' \
		 'mandir=${mandir}'"

do_install () {
	oe_runmake 'ROOT=${D}' install
	install -d ${D}/${sysconfdir} \
		   ${D}/${sysconfdir}/default \
		   ${D}/${sysconfdir}/init.d
	install -m 0644 ${WORKDIR}/inittab ${D}/${sysconfdir}/inittab
	if [ ! -z "${SERIAL_CONSOLE}" ]; then
		echo "S:2345:respawn:/sbin/getty ${SERIAL_CONSOLE}" >> ${D}/etc/inittab
	fi
	if [ "${USE_VT}" == "1" ]; then
		cat <<EOF >>${D}/etc/inittab
# /sbin/getty invocations for the runlevels.
#
# The "id" field MUST be the same as the last
# characters of the device (after "tty").
#
# Format:
#  <id>:<runlevels>:<action>:<process>
#
1:2345:respawn:/sbin/getty 38400 tty1
# 2:23:respawn:/sbin/getty 38400 tty2
# 3:23:respawn:/sbin/getty 38400 tty3
# 4:23:respawn:/sbin/getty 38400 tty4
EOF
	fi
	install -m 0644    ${WORKDIR}/rcS-default	${D}/etc/default/rcS
	install -m 0755    ${WORKDIR}/rc		${D}/etc/init.d
	install -m 0755    ${WORKDIR}/rcS		${D}/etc/init.d
	install -m 0755    ${WORKDIR}/bootlogd.init     ${D}/etc/init.d/bootlogd
	ln -sf bootlogd ${D}/etc/init.d/stop-bootlogd
	install -d ${D}/etc/rcS.d
	ln -sf ../init.d/bootlogd ${D}/etc/rcS.d/S07bootlogd
	for level in 2 3 4 5; do
		install -d ${D}/etc/rc$level.d
		ln -s ../init.d/stop-bootlogd ${D}/etc/rc$level.d/S99stop-bootlogd
	done
	mv                 ${D}/sbin/init               ${D}/sbin/init.sysvinit
}


do_install_append_ramses () {
	cat <<EOF >>${D}/etc/inittab
# Bluetooth
#1:2345:respawn:/sbin/getty -L 115200 tts/1
# External serial port
4:2345:respawn:/sbin/getty -L 115200 tts/4
# Framebuffer
v1:2345:respawn:/sbin/getty -L 115200 vc/1
EOF
}
