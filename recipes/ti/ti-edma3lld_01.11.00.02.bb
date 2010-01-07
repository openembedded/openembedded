require ti-edma3lld.inc

#SRC_URI[edma3lldbin.md5sum] = "fa15c104cfe03227bf181ecf4094c0d9"
#SRC_URI[edma3lldbin.sha256sum] = "9650d1fc8b441d46095a8b4e70dab5d7438351f38e03918d30bed0e4ffc50e66"

SRC_URI[edma3lldtarball.md5sum] = "358c13c1c28c6074f1d340c4e8a9e5cf"
SRC_URI[edma3lldtarball.sha256sum] = "5de884b0479390bc91dd83c23df2f742106cc001ac638849be276ba8be40bb7c"

PV = "01_11_00_02"

do_stage() {
    install -d ${STAGING_DIR_NATIVE}/ti-edma3lld
    cp -pPrf ${S}/* ${STAGING_DIR_NATIVE}/ti-edma3lld
}


