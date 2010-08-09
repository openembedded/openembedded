## Reminder:  The correct spacing for a variable is FOO = "BAR"  in : PR="r1"
DESCRIPTION = "BeagleBoard test scripts"
HOMEPAGE = "http://beagleboad.org/support"
PR = "r1"

SRC_URI = "git://gitorious.org/beagleboard-validation/scripts.git;protocol=git \
"

SRCREV = "f009c731df5c410eb819fa90f199713ea60cea6a"
S = "${WORKDIR}/git"

do_install() {
  TEST_FILES=" \
    testaudio \
    testcamera \
    testedid \
    testled \
    testsvideo \
    testuserbtn \
    editbootscr \
    edituserscr \
    readgpio \
  "
  install -d ${D}/${bindir}
  for i in ${TEST_FILES}; do
    install -m 0755 ${S}/${i} ${D}/${bindir}
  done
}
