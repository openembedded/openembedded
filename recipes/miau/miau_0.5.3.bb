DESCRIPTION = "MIAU IRC Bouncer"
SECTION = "network"
PRIORITY = "optional"
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

SRC_URI[md5sum] = "7f6a372f1f9371094d0dd433b89ec48d"
SRC_URI[sha256sum] = "ebede057bf1c312182d069b958eccfafbb18fca4cbba0a41f0c5f35094cb15e2"
