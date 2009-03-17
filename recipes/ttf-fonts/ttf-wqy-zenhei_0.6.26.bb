require ttf.inc

DESCRIPTION = "WenQuanYi Zen Hei - A Hei-Ti Style Chinese font"
AUTHOR = "Qianqian Fang and The WenQuanYi Project Contributors"
HOMEPAGE = "http://wqy.sourceforge.net/en/"
LICENSE = "GPLv2"

SRC_URI = "${SOURCEFORGE_MIRROR}/wqy/wqy-zenhei-${PV}-0.tar.gz"
S = "${WORKDIR}/wqy-zenhei"

do_install_append () { 
	install -d ${D}${sysconfdir}/fonts/conf.d/
	install -m 0644 ${S}/44-wqy-zenhei.conf ${D}${sysconfdir}/fonts/conf.d/
	install -m 0644 ${S}/66-wqy-zenhei-sharp.conf ${D}${sysconfdir}/fonts/conf.d/
}

PACKAGES = "${PN}"

FILES_${PN} = "${datadir}/fonts ${sysconfdir}"
