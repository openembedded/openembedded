require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_apps_qcop.tar.bz2;name=split_core_apps_qcop \
           file://unbreak-logging.patch"
SRC_URI[split_core_apps_qcop.md5sum] = "6d2616f81989361c30b2f3502084b9c3"
SRC_URI[split_core_apps_qcop.sha256sum] = "c35f64660758ff9ed686bf7174f92df5fff3c07a845e8c60fc0b7a522ef49c5d"
