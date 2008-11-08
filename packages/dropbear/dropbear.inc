DESCRIPTION = "Dropbear is a lightweight SSH and SCP implementation"
HOMEPAGE = "http://matt.ucc.asn.au/dropbear/dropbear.html"
SECTION = "console/network"
LICENSE = "MIT"
DEPENDS = "zlib"
PROVIDES = "ssh sshd"
RPROVIDES = "ssh sshd"

SRC_URI = "\
  http://matt.ucc.asn.au/dropbear/dropbear-${PV}.tar.bz2 \
  file://urandom-xauth-changes-to-options.h.patch;patch=1 \
  file://configure.patch;patch=1 \
  file://fix-2kb-keys.patch;patch=1 \
  file://allow-nopw.patch \
  file://init \
"
SRC_URI_append_openmoko = "\
  file://default \
"

inherit autotools update-rc.d

INITSCRIPT_NAME = "dropbear"
INITSCRIPT_PARAMS = "defaults 10"

CFLAGS =+ "-I."
LD = "${CC}"

SBINCOMMANDS = "dropbear dropbearkey dropbearconvert"
BINCOMMANDS = "dbclient ssh scp"
EXTRA_OEMAKE = 'MULTI=1 SCPPROGRESS=1 PROGRAMS="${SBINCOMMANDS} ${BINCOMMANDS}"'

do_configure_prepend() {
	if [ "x${DISTRO_TYPE}" = "xdebug" ]; then
		oenote "WARNING: applying allow-nopw.patch which allows password-less logins!"
		patch -p1 < ${WORKDIR}/allow-nopw.patch
	fi
}

do_install() {
	install -d ${D}${sysconfdir}
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/default
	install -d ${D}${sysconfdir}/dropbear
	install -d ${D}${bindir}
	install -d ${D}${sbindir}
	install -d ${D}${localstatedir}

	install -m 0755 dropbearmulti ${D}${sbindir}/
	ln -s ${sbindir}/dropbearmulti ${D}${bindir}/dbclient
	
	for i in ${SBINCOMMANDS}
	do
		ln -sf ./dropbearmulti ${D}${sbindir}/$i
	done
	cat ${WORKDIR}/init | sed -e 's,/etc,${sysconfdir},g' \
				  -e 's,/usr/sbin,${sbindir},g' \
				  -e 's,/var,${localstatedir},g' \
				  -e 's,/usr/bin,${bindir},g' \
				  -e 's,/usr,${prefix},g' > ${D}${sysconfdir}/init.d/dropbear
	chmod 755 ${D}${sysconfdir}/init.d/dropbear
	if test -e ${WORKDIR}/default ; then
		install -m 0644 ${WORKDIR}/default ${D}${sysconfdir}/default/dropbear
	fi
}

pkg_postinst () {
	update-alternatives --install ${bindir}/scp scp ${sbindir}/dropbearmulti 20
	update-alternatives --install ${bindir}/ssh ssh ${sbindir}/dropbearmulti 20
}

pkg_postrm_append () {
	if [ -f "${sysconfdir}/dropbear/dropbear_rsa_host_key" ]; then
		rm ${sysconfdir}/dropbear/dropbear_rsa_host_key
	fi
	if [ -f "${sysconfdir}/dropbear/dropbear_dss_host_key" ]; then
		rm ${sysconfdir}/dropbear/dropbear_dss_host_key
	fi
	update-alternatives --remove ssh ${bindir}/dropbearmulti
	update-alternatives --remove scp ${bindir}/dropbearmulti
}

CONFFILES_${PN}_openmoko += "${sysconfdir}/default/dropbear"
