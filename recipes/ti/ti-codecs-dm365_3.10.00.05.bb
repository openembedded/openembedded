DESCRIPTION = "DM365 Codecs"
SECTION = "multimedia"
LICENSE = "TI"

PV = "03_10_00_05"

SRC_URI = "http://tigt_dev.gt.design.ti.com/dev/DVSDK/310_DVSDK/3_10_00/dm365_codecs_${PV}.tar.gz;name=dm365codecs \
           file://mapdmaq"

SRC_URI[dm365codecs.md5sum] = "c336e76101340b7a4f19214401824efe"
SRC_URI[dm365codecs.sha256sum] = "3ad43dcaf1b965c99a286f30cea928cf887308f7433ec0e6fd814954d91d0512"

S = "${WORKDIR}/dm365_codecs_${PV}"

PROVIDES += "ti-codecs-dm365-server"

require ti-paths.inc
require ti-staging.inc

do_compile() {
	echo "Do nothing"
}

do_install () {
	install -d ${D}/${installdir}/ti-codecs-server
	cd ${S}

	install -m 0755 ${WORKDIR}/mapdmaq ${D}/${installdir}/ti-codecs-server

	install -d ${D}${CODEC_INSTALL_DIR_RECIPE}
	cp -pPrf ${S}/* ${D}${CODEC_INSTALL_DIR_RECIPE}
}

PACKAGES += "ti-codecs-dm365-server"
FILES_ti-codecs-dm365-server = "${installdir}/ti-codecs-server/*"

INSANE_SKIP_ti-codecs-dm365-server = True
