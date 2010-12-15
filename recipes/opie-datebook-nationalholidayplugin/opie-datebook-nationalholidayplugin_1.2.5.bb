require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_pim_datebook_plugins_national.tar.bz2;name=split_core_pim_datebook_plugins_national \
           http://sources.openembedded.org/opie-1.2.5-split_etc_nationaldays.tar.bz2;name=split_etc_nationaldays"
SRC_URI[split_core_pim_datebook_plugins_national.md5sum] = "cc7de5c238a2054f9343f1a7a967a1bf"
SRC_URI[split_core_pim_datebook_plugins_national.sha256sum] = "42444fcabf7450ef0aad27b7653ed9e761cbfbaca0094f129528c573ca6c456a"
SRC_URI[split_etc_nationaldays.md5sum] = "8810a5d0c7a4eb1de5f5750297db390d"
SRC_URI[split_etc_nationaldays.sha256sum] = "8a6286e24766f000c3387df2f083e59bcded12fca92ff6704fc0e5c7f5ab84a8"
