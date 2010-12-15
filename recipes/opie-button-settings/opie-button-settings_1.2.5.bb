require ${PN}.inc

SRC_URI = "http://sources.openembedded.org/opie-1.2.5-split_core_settings_button.tar.bz2;name=split_core_settings_button \
           http://sources.openembedded.org/opie-1.2.5-split_pics.tar.bz2;name=split_pics \
           http://sources.openembedded.org/opie-1.2.5-split_apps.tar.bz2;name=split_apps"
SRC_URI[split_core_settings_button.md5sum] = "8fd4026daead46cb1ad42d44b7d779ae"
SRC_URI[split_core_settings_button.sha256sum] = "2b108ed88a2e0783014fb5cdfec50533efef175014ebc848686a692690e4a273"
SRC_URI[split_pics.md5sum] = "e9b68749d67295f7080a23e39b17335e"
SRC_URI[split_pics.sha256sum] = "0a7aab6d0bce04d6a9c257d768d8a1a481d38ba527d6e6e50723973789954b4a"
SRC_URI[split_apps.md5sum] = "c765d13427e4dc8ee396e4dfed2dbe73"
SRC_URI[split_apps.sha256sum] = "0fea454d8d286f7febc7449e4a06f73e941e8b22e9bab904a32e57f35479862a"
