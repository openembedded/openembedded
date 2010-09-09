require ti-codec-engine.inc

PV = "2_26_00_08"

SRC_URI[cetarball.md5sum] = "4146a441a187c38292dccec661e48d89"
SRC_URI[cetarball.sha256sum] = "98e8a0db6d1b473679156089bcc3ed7cc5e03006e96e7956d4c35a8e940ec16f"

# update 3530 loadmodule to use mem=99 
do_configure_dm37x-evm_prepend () {
    sed -i  \
        -e s:"phys_start=0x85000000 phys_end=0x86000000":"phys_start=0x86300000 phys_end=0x87200000":g \
        ${S}/examples/apps/system_files/${CEEXAMPLESDEVICES}/loadmodules.sh

}

