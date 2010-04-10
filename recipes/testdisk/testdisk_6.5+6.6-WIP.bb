DESCRIPTION = "TestDisk is a powerful free data recovery software! It was primarily designed to help recover lost partitions and/or make non-booting disks bootable again when these symptoms are caused by faulty software, certain types of viruses or human error (such as accidentally deleting your Partition Table)."
LICENSE = "GPLv2"

DEPENDS = "jpeg ncurses e2fsprogs"

SRC_URI = "http://www.cgsecurity.org/testdisk-6.6-WIP.tar.bz2"
S = "${WORKDIR}/testdisk-6.6-WIP"

inherit autotools pkgconfig

PACKAGES =+ "photorec"

DESCRIPTION_photorec = "Photorec is file data recovery software designed to recover lost files including video, documents and archives from Hard Disks and CDRom and lost pictures (Photo Recovery) from digital camera memory."
FILES_photorec = "${sbindir}/photorec"

SRC_URI[md5sum] = "3cc59a7e425c49dbdf76b54d85b55619"
SRC_URI[sha256sum] = "2b472be7105eaa88e0c9cca241225c56fdcb80d34dec60ef1d865b0877be771c"
