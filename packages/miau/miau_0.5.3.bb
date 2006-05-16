DESCRIPTION = "MIAU IRC Bouncer"
SECTION = "network"
PRIORITY = "optional"
MAINTAINER = "NSLU2 Linux <www.nslu2-linux.org>"
HOMEPAGE = "http://sf.net/project/miau/"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/miau/miau-${PV}.tar.gz \
           file://paths.patch;patch=1 \
	   file://miau.init"
S = "${WORKDIR}/miau-${PV}"

inherit autotools update-rc.d

INITSCRIPT_NAME = "miau"
INITSCRIPT_PARAMS = "defaults 80"

EXTRA_OECONF = "\
		--enable-dccbounce \
		--enable-automode \
		--enable-releasenick \
		--enable-ctcp-replies \
		--enable-mkpasswd \
		--enable-uptime \
		--enable-chanlog \
		--enable-privlog \
		--enable-onconnect \
		--enable-empty-awaymsg \
		--enable-enduserdebug \
		--enable-pingstat \
		--enable-dumpstatus \
	"

do_install_append() {
	install -d ${D}${localstatedir}/spool/miau
	install -d ${D}${sysconfdir}/init.d
	install -m 0644 ${S}/misc/miaurc ${D}${sysconfdir}/miau.conf
	install -m 0755 ${WORKDIR}/miau.init ${D}${sysconfdir}/init.d/miau
}

CONFFILES_${PN} = "${sysconfdir}/miau.conf"
