require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_core_pim_datebook_holiday_national.tar.bz2;name=split_core_pim_datebook_holiday_national \
           http://sources.openembedded.org/opie-1.2.4-split_etc_nationaldays.tar.bz2;name=split_etc_nationaldays"
SRC_URI[split_core_pim_datebook_holiday_national.md5sum] = "d0d75e5d168f24968fcb6ef7195a602b"
SRC_URI[split_core_pim_datebook_holiday_national.sha256sum] = "8a514fbbc9275c71688a6522838031f213bb34c95f65bebb215db4463366ce98"
SRC_URI[split_etc_nationaldays.md5sum] = "c72f9a69ed7c9fb7718d18a28ca30b18"
SRC_URI[split_etc_nationaldays.sha256sum] = "227754482127bfc550353d727d45eceab4cf491ac6d3e23ee83cf5e28858b379"
