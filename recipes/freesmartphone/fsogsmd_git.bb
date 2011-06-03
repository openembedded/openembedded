require cornucopia.inc
inherit fso-plugin
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"
SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PR = "${INC_PR}.2"
PV = "0.5.0+gitr${SRCPV}"
PE = "1"

DEPENDS += "libfsoresource libgsm0710mux libgisi ppp connman msmcomm-specs"

EXTRA_OECONF_append = "\
  --enable-libgsm0710mux \
  --enable-modem-nokia-isi \
  --enable-modem-qualcomm-palm \
"

# package modules with extra dependencies in extra packages RDEPENDed by config package

PACKAGES =+ "${PN}-config"
FILES_${PN}-config = "${sysconfdir}/freesmartphone/"
PACKAGE_ARCH_${PN}-config = "${MACHINE_ARCH}"
CONFFILES_${PN}-config = " \
  ${sysconfdir}/freesmartphone/conf/openmoko_gta/fsogsmd.conf \
  ${sysconfdir}/freesmartphone/conf/palm_pre/fsogsmd.conf \
  ${sysconfdir}/freesmartphone/conf/htc_qualcomm_dream/fsogsmd.conf \
  ${sysconfdir}/freesmartphone/conf/htc_qualcomm_msm/fsogsmd.conf \
"
RDEPENDS_${PN} += "${PN}-config"

PACKAGES =+ "${PN}-connman ${PN}-connman-dev ${PN}-connman-dbg"
FILES_${PN}-connman = "${libdir}/connman/plugins/fsogsm.so"
FILES_${PN}-connman-dev = "${libdir}/connman/plugins/fsogsm.la"
FILES_${PN}-connman-dbg = "${libdir}/connman/plugins/.debug/fsogsm*"
RDEPENDS_${PN} += "${PN}-connman"

# On the palmpre we need the msmcomm daemon to talk to the modem
RDEPENDS_${PN}-config_palmpre += "msmcommd"

PACKAGES =+ "${PN}-module-lowlevel-palmpre ${PN}-module-lowlevel-palmpre-dev ${PN}-module-lowlevel-palmpre-dbg"
FILES_${PN}-module-lowlevel-palmpre = "${CORNUCOPIA_MODULE_DIR}/lowlevel_palmpre.so"
FILES_${PN}-module-lowlevel-palmpre-dev = "${CORNUCOPIA_MODULE_DIR}/lowlevel_palmpre.la"
FILES_${PN}-module-lowlevel-palmpre-dbg = "${CORNUCOPIA_MODULE_DIR}/.debug/lowlevel_palmpre*"
RDEPENDS_${PN}-config_palmpre += "${PN}-module-lowlevel-palmpre"

PACKAGES =+ "${PN}-module-modem-qualcomm-palm ${PN}-module-modem-qualcomm-palm-dev ${PN}-module-modem-qualcomm-palm-dbg"
FILES_${PN}-module-modem-qualcomm-palm = "${CORNUCOPIA_MODULE_DIR}/modem_qualcomm_palm.so"
FILES_${PN}-module-modem-qualcomm-palm-dev = "${CORNUCOPIA_MODULE_DIR}/modem_qualcomm_palm.la"
FILES_${PN}-module-modem-qualcomm-palm-dbg = "${CORNUCOPIA_MODULE_DIR}/.debug/modem_qualcomm_palm*"
RDEPENDS_${PN}-config_palmpre += "${PN}-module-modem-qualcomm-palm"

PACKAGES =+ "${PN}-module-modem-qualcomm-htc ${PN}-module-modem-qualcomm-htc-dev ${PN}-module-modem-qualcomm-htc-dbg"
FILES_${PN}-module-modem-qualcomm-htc = "${CORNUCOPIA_MODULE_DIR}/modem_qualcomm_htc.so"
FILES_${PN}-module-modem-qualcomm-htc-dev = "${CORNUCOPIA_MODULE_DIR}/modem_qualcomm_htc.la"
FILES_${PN}-module-modem-qualcomm-htc-dbg = "${CORNUCOPIA_MODULE_DIR}/.debug/modem_qualcomm_htc*"
RDEPENDS_${PN}-config_htcdream += "${PN}-module-modem-qualcomm-htc"

PACKAGES =+ "${PN}-module-modem-nokia-isi ${PN}-module-modem-nokia-isi-dev ${PN}-module-modem-nokia-isi-dbg"
FILES_${PN}-module-modem-nokia-isi = "${CORNUCOPIA_MODULE_DIR}/modem_nokia_isi.so"
FILES_${PN}-module-modem-nokia-isi-dev = "${CORNUCOPIA_MODULE_DIR}/modem_nokia_isi.la"
FILES_${PN}-module-modem-nokia-isi-dbg = "${CORNUCOPIA_MODULE_DIR}/.debug/modem_nokia_isi*"
RDEPENDS_${PN}-config_nokia900 += "${PN}-module-modem-nokia-isi"

PACKAGES =+ "${PN}-module-lowlevel-openmoko ${PN}-module-lowlevel-openmoko-dev ${PN}-module-lowlevel-openmoko-dbg"
FILES_${PN}-module-lowlevel-openmoko = "${CORNUCOPIA_MODULE_DIR}/lowlevel_openmoko.so"
FILES_${PN}-module-lowlevel-openmoko-dev = "${CORNUCOPIA_MODULE_DIR}/lowlevel_openmoko.la"
FILES_${PN}-module-lowlevel-openmoko-dbg = "${CORNUCOPIA_MODULE_DIR}/.debug/lowlevel_openmoko*"
RDEPENDS_${PN}-config_om-gta01 += "${PN}-module-lowlevel-openmoko"
RDEPENDS_${PN}-config_om-gta02 += "${PN}-module-lowlevel-openmoko"

PACKAGES =+ "${PN}-module-modem-ti-calypso ${PN}-module-modem-ti-calypso-dev ${PN}-module-modem-ti-calypso-dbg"
FILES_${PN}-module-modem-ti-calypso = "${CORNUCOPIA_MODULE_DIR}/modem_ti_calypso.so"
FILES_${PN}-module-modem-ti-calypso-dev = "${CORNUCOPIA_MODULE_DIR}/modem_ti_calypso.la"
FILES_${PN}-module-modem-ti-calypso-dbg = "${CORNUCOPIA_MODULE_DIR}/.debug/modem_ti_calypso*"
RDEPENDS_${PN}-config_om-gta01 += "${PN}-module-modem-ti-calypso"
RDEPENDS_${PN}-config_om-gta02 += "${PN}-module-modem-ti-calypso"

PACKAGES =+ "${PN}-module-modem-freescale-neptune ${PN}-module-modem-freescale-neptune-dev ${PN}-module-modem-freescale-neptune-dbg"
FILES_${PN}-module-modem-freescale-neptune = "${CORNUCOPIA_MODULE_DIR}/modem_freescale_neptune.so"
FILES_${PN}-module-modem-freescale-neptune-dev = "${CORNUCOPIA_MODULE_DIR}/modem_freescale_neptune.la"
FILES_${PN}-module-modem-freescale-neptune-dbg = "${CORNUCOPIA_MODULE_DIR}/.debug/modem_freescale_neptune*"
RDEPENDS_${PN}-config_motorola-ezx += "${PN}-module-modem-freescale-neptune"

PACKAGES =+ "${PN}-module-lowlevel-motorola-ezx ${PN}-module-lowlevel-motorola-ezx-dev ${PN}-module-lowlevel-motorola-ezx-dbg"
FILES_${PN}-module-lowlevel-motorola-ezx = "${CORNUCOPIA_MODULE_DIR}/lowlevel_motorola_ezx.so"
FILES_${PN}-module-lowlevel-motorola-ezx-dev = "${CORNUCOPIA_MODULE_DIR}/lowlevel_motorola_ezx.la"
FILES_${PN}-module-lowlevel-motorola-ezx-dbg = "${CORNUCOPIA_MODULE_DIR}/.debug/lowlevel_motorola_ezx*"
RDEPENDS_${PN}-config_motorola-ezx += "${PN}-module-lowlevel-motorola-ezx"


## shared modules or modules without known OE machine to RDEPEND on them (so kept in main module for now)
#  dbus_service.so
#  modem_dummy.so
#  modem_cinterion_mc75.so
#  modem_singleline.so
#  pdp_ppp.so
#  pdp_ppp_internal.so
#  pdp_ppp_mux.so
#  pdp_qmi.so
#  ppp2fsogsmd.so

## motorola-ezx
#  modem_freescale_neptune.so
#  lowlevel_motorola_ezx.so

## nokia900
#  lowlevel_nokia900.so
#  modem_nokia_isi.so

## openmoko
#  lowlevel_openmoko.so
#  modem_ti_calypso.so

## palmpre
#  modem_qualcomm_pre.so
#  lowlevel_palmpre.so

## htcdream
#  modem_qualcomm_htc.so

