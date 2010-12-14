require ${PN}.inc

PR = "r1"

SRC_URI = "http://sources.openembedded.org/opie-1.2.4-split_noncore_applets_memoryapplet.tar.bz2;name=split_noncore_applets_memoryapplet \
           http://sources.openembedded.org/opie-1.2.4-split_noncore_settings_sysinfo.tar.bz2;name=split_noncore_settings_sysinfo \
           http://sources.openembedded.org/opie-1.2.4-split_pics.tar.bz2;name=split_pics"
SRC_URI[split_noncore_applets_memoryapplet.md5sum] = "f6f03a5b1c18d26d3c205c3271202401"
SRC_URI[split_noncore_applets_memoryapplet.sha256sum] = "f76bf6c05aef1ca919448404a150d070a6f1a7ce0b2e0ecff3209458f5835e28"
SRC_URI[split_noncore_settings_sysinfo.md5sum] = "de964e2b3077cb3c8119a89b27405f34"
SRC_URI[split_noncore_settings_sysinfo.sha256sum] = "6ff406879b864a6a4d516eaef3e7e4f314d5796c941d63d985fa093724552e79"
SRC_URI[split_pics.md5sum] = "5499dc84b65395ab99bda6ed9d01ff0f"
SRC_URI[split_pics.sha256sum] = "f22781f36e84e12d51fff1eb68cc3fb98221c7d807a82226813b7e974a604109"
