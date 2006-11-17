# To use, put the following (uncommented) in your local.conf.
# Make sure that you don't set MACHINE in your local.conf
#
#include auto.conf
#STAMP = "${TMPDIR}/stamps/${PACKAGE_ARCH}-${TARGET_OS}/${PF}"
#WORKDIR = "${TMPDIR}/work/${PACKAGE_ARCH}-${TARGET_OS}/${PF}"
#STAGING_KERNEL_DIR = "${STAGING_DIR}/${PACKAGE_ARCH}-${TARGET_OS}/kernel"
#KERNEL_STAGING = "${STAGING_DIR}/${PACKAGE_ARCH}-${TARGET_OS}/kernel"

for machine in spitz poodle akita borzoi c7x0 tosa collie;
do
        rm conf/auto.conf
        echo "MACHINE = \"$machine\"" > conf/auto.conf
        echo "MACHINE = \"$machine\""

        [ -e script ] && rm script
        #echo "rebuild virtual/kernel; exit" > script
        echo "rebuild initscripts; rebuild sysvinit; rebuild tslib; rebuild altboot; build bootstrap-image; build gpe-image; build e-image-core; build e-image; rebuild virtual/libqte2; rebuild virtual/libqpe; rebuild opie-button-settings; build opie-image; exit" > script
        bitbake -i < script
done

rm script