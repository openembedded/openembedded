TEMPLATE = subdirs
CONFIG += ordered
!gtk-port:CONFIG += qt-port
qt-port:!win32-*:SUBDIRS += WebKitQt/Plugins
SUBDIRS += \
        WebCore \
        JavaScriptCore/kjs/testkjs.pro

qt-port {
    SUBDIRS += WebKitQt/QtLauncher

    !win32-*: SUBDIRS += WebKitTools/DumpRenderTree/DumpRenderTree.qtproj/DumpRenderTree.pro
}

gtk-port:SUBDIRS += \
        WebKitTools/GtkLauncher
