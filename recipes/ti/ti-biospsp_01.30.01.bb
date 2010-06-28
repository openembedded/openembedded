require ti-biospsp.inc

PV = "01_30_01"

SRC_URI[biospsptarball.md5sum] = "92096326d0b6d82bac758b622b5f2b50"
SRC_URI[biospsptarball.sha256sum] = "87acc688c06152569b8faa1480ff5f0c040e2fbdd6c2a4a0b30b8d8b0aa72314"

# Internal Release Only - SRC_URI is not public yet - override link
HTTP_PROXY_IGNORE="ftp.india.ti.com"
SRC_URI = "ftp://ftp.india.ti.com/PSP/Releases/ODC/Freon_BIOS_PSP/REL.BIOSPSP.01.30.01.GA/BIOSPSP_${PV}.tar.gz;name=biospsptarball"

