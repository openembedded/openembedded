## Reminder:  The correct spacing for a variable is FOO = "BAR"  in : PR="r1"
DESCRIPTION = "BeagleBoard test scripts"
HOMEPAGE = "http://beagleboad.org/support"
PR = "r2"

SRC_URI = "git://gitorious.org/beagleboard-validation/scripts.git;protocol=git \
"

SRCREV = "473dd2ab20d866be6168c9f992c2c9e74e485c9d"
S = "${WORKDIR}/git"

do_install() {
  TEST_FILES=" \
    testaudio \
    testcamera \
    testdsp \
    testedid \
    testled \
    testmem \
    testneon \
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
