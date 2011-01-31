require barebox.inc

PR = "r0"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_vmx25 = "1"

BAREBOX_REVISION ?= "0"

S = "${WORKDIR}/barebox-${PV}.${BAREBOX_REVISION}"

SRC_URI = "\
	http://barebox.org/download/barebox-${PV}.${BAREBOX_REVISION}.tar.bz2;name=barebox-${PV}.${BAREBOX_REVISION} \
	file://defconfig \
	"

SRC_URI_append_vmx25 = "\
	file://barebox_2010.10-vmx25-20110112.patch; \
	"

SRC_URI[barebox-2010.10.0.md5sum] = "60c208f86333430804d6e2ed40e4ff33"
SRC_URI[barebox-2010.10.0.sha256sum] = "4ba3b6aa4cb0ad91dcf3c4f15951dc5f642ed86e5297bfd79d842cc1ad0b7841"
