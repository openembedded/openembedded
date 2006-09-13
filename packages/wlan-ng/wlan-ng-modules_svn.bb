require wlan-ng-modules.inc
PR = "r0"
PV = "0.2.4+svn${SRCDATE}"

SRC_URI += "svn://svn.shaftnet.org/linux-wlan-ng;module=trunk "
S = "${WORKDIR}/trunk"

DEFAULT_PREFERENCE = "-1"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/${PN}-0.2.4+svn20060823', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}/wlan-ng-modules' ], d)}"
