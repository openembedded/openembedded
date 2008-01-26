PV = "2.10.2"
PR = "r1"
SDIRVER = "210"
SEXT = "bz2"

inherit mono pkgconfig
require gtk-sharp.inc

FILES_libgtk2.0-cil = "/usr/lib/libgtksharpglue-2.so \
	/usr/lib/libgdksharpglue-2.so \
	/usr/lib/libpangosharpglue-2.so \
	/usr/lib/mono/gac/gtk-sharp \
	/usr/lib/mono/gac/gdk-sharp \
	/usr/lib/mono/gac/atk-sharp \
	/usr/lib/mono/gac/pango-sharp \
	/usr/lib/mono/gac/gtk-dotnet \
	/usr/lib/mono/gtk-sharp-2.0/gtk-sharp.dll \
	/usr/lib/mono/gtk-sharp-2.0/gdk-sharp.dll \
	/usr/lib/mono/gtk-sharp-2.0/atk-sharp.dll \
	/usr/lib/mono/gtk-sharp-2.0/pango-sharp.dll \
	/usr/lib/mono/gtk-sharp-2.0/gtk-dotnet.dll \
	/usr/lib/mono/gac/policy.2.*.gtk-sharp/ \
	/usr/lib/mono/gac/policy.2.*.gdk-sharp/ \
	/usr/lib/mono/gac/policy.2.*.atk-sharp/ \
	/usr/lib/mono/gac/policy.2.*.pango-sharp/ \
	/usr/lib/mono/gac/policy.2.*.gtk-dotnet/ \
        /usr/lib/mono/gtk-sharp-2.0/policy.2.*.gtk-sharp.dll \
        /usr/lib/mono/gtk-sharp-2.0/policy.2.*.gdk-sharp.dll \
        /usr/lib/mono/gtk-sharp-2.0/policy.2.*.atk-sharp.dll \
        /usr/lib/mono/gtk-sharp-2.0/policy.2.*.pango-sharp.dll \
        /usr/lib/mono/gtk-sharp-2.0/policy.2.*.gtk-dotnet.dll \
	"
FILES_libgtk2.0-cil-dev = "/usr/lib/pkgconfig/gtk-sharp-2.0.pc \
	/usr/lib/pkgconfig/gtk-dotnet-2.0.pc \
	/usr/share/gapi-2.0/pango-api.xml \
	/usr/share/gapi-2.0/atk-api.xml \
        /usr/share/gapi-2.0/gdk-api.xml \
        /usr/share/gapi-2.0/gtk-api.xml"
FILES_libgtk2.0-cil-dbg += "/usr/lib/.debug/libgtksharpglue-2.so \
	/usr/lib/.debug/libgdksharpglue-2.so \
	/usr/lib/.debug/libpangosharpglue-2.so"

FILES_libglib2.0-cil = "/usr/lib/mono/gac/glib-sharp \
	/usr/lib/libglibsharpglue-2.so \
	/usr/lib/mono/gtk-sharp-2.0/glib-sharp.dll \
	/usr/lib/mono/gac/policy.2.*.glib-sharp/ \
	/usr/lib/mono/gtk-sharp-2.0/policy.2.*.glib-sharp.dll"
FILES_libglib2.0-cil-dev = "/usr/lib/pkgconfig/glib-sharp-2.0.pc"
FILES_libglib2.0-cil-dbg += "/usr/lib/.debug/libglibsharpglue-2.so"

FILES_libglade2.0-cil = "/usr/lib/mono/gac/glade-sharp \
	/usr/lib/libgladesharpglue-2.so \
	/usr/lib/mono/gtk-sharp-2.0/glade-sharp.dll \
	/usr/lib/mono/gac/policy.2.*.glade-sharp/ \
	/usr/lib/mono/gtk-sharp-2.0/policy.2.*.glade-sharp.dll"
FILES_libglade2.0-cil-dev = "/usr/lib/pkgconfig/glade-sharp-2.0.pc \
	/usr/share/gapi-2.0/glade-api.xml"
FILES_libglade2.0-cil-dbg += "/usr/lib/.debug/libgladesharpglue-2.so"

FILES_gtk-sharp-gapi2 = " \
	/usr/bin/gapi2-* \
	/usr/lib/gtk-sharp-2.0/gapi*"
FILES_gtk-sharp-gapi2-dev = "/usr/lib/pkgconfig/gapi-2.0.pc"

FILES_gtk-sharp2-glue-dev = "/usr/lib/libgtksharpglue-2.la \
	/usr/lib/libgtksharpglue-2.a \
	/usr/lib/libpangosharpglue-2.la \
	/usr/lib/libpangosharpglue-2.a \
	/usr/lib/libgdksharpglue-2.la \
	/usr/lib/libgdksharpglue-2.a"

FILES_glade-sharp2-glue-dev = " \
	/usr/lib/libgladesharpglue-2.la \
	/usr/lib/libgladesharpglue-2.a"

FILES_glib-sharp2-glue-dev = " \
	/usr/lib/libglibsharpglue-2.la \
	/usr/lib/libglibsharpglue-2.a"

PACKAGES = "libgtk2.0-cil libgtk2.0-cil-dev libgtk2.0-cil-dbg \
	libglib2.0-cil libglib2.0-cil-dev libglib2.0-cil-dbg \
	libglade2.0-cil libglade2.0-cil-dev libglade2.0-cil-dbg \
	gtk-sharp-gapi2 gtk-sharp-gapi2-dev \
	gtk-sharp2-glue-dev glade-sharp2-glue-dev glib-sharp2-glue-dev"
