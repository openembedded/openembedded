require mtd-utils_1.2.0+git.bb

# this can probably be integrated into the main mtd-utils package
# but I did not want to risk breakage -- but would be glad to 
# integrate them if that is best -- cbrake

SRC_URI = "git://git.infradead.org/mtd-utils.git;protocol=git;tag=${TAG}"

PR = "r1"

S = "${WORKDIR}/git/tests/fs-tests"

FILES_${PN} = "${datadir}/mtd-utils"

do_compile () {
	make || die "Make failed"
}

do_stage () {
}

INHIBIT_PACKAGE_STRIP = "1"

mtd_utils_tests = " \
	help_all.sh \
	run_all.sh \
	integrity/integck \
	simple/ftrunc \
	simple/test_1 \	
	simple/test_2 \	
	stress/stress00.sh \
	stress/stress01.sh \
	stress/atoms/fwrite00 \
	stress/atoms/gcd_hupper \
	stress/atoms/pdfrun \
	stress/atoms/rmdir00 \
	stress/atoms/rndrm00 \
	stress/atoms/rndrm99 \
	stress/atoms/rndwrite00 \
	stress/atoms/stress_1 \
	stress/atoms/stress_2 \
	stress/atoms/stress_3 \
	utils/free_space \
	utils/fstest_monitor \
	"
	
do_install () {
	install -d ${D}${datadir}/mtd-utils/tests
	install -d ${D}${datadir}/mtd-utils/tests/integrity  
	install -d ${D}${datadir}/mtd-utils/tests/simple  
	install -d ${D}${datadir}/mtd-utils/tests/stress
	install -d ${D}${datadir}/mtd-utils/tests/stress/atoms
	install -d ${D}${datadir}/mtd-utils/tests/utils
	for app in ${mtd_utils_tests}; do
		install -m 0755 $app ${D}${datadir}/mtd-utils/tests/$app
	done
}


