require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_noncore_settings_language.tar.bz2;name=split_noncore_settings_language \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_noncore_settings_language.md5sum] = "0a73fbfea8b25194041903383c6213b6"
SRC_URI[split_noncore_settings_language.sha256sum] = "90f912f6804cfcd362dbfaebf76d36a39e317f8f3da9c8bce6bdf49d72a361b1"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
