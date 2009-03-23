DESCRIPTION = "Standalone web server written in C# that can be used to run ASP.NET applications"
SECTION = "devel/mono"

# Issues:
#  - packaging of mono-xsp is still broken.  It using using the default
#    FILES list instead of the one specified below
#  - scripts in /usr/bin contain the wrong paths
#


PR = "r4"

DEPENDS = "mono"
RDEPENDS = "mono"

inherit autotools mono

SRC_URI = "http://go-mono.com/sources/xsp/xsp-${PV}.tar.bz2"

S = "${WORKDIR}/xsp-${PV}"

PACKAGES = "${PN}-dbg \
	libmono-webserver1.0-cil \
	libmono-webserver2.0-cil \
	mono-xsp \
	mono-xsp2 \
	mono-xsp-test \
	mono-mod-mono-server \
	mono-mod-mono-server2 \
	mono-xsp-doc \
	mono-xsp-dev \
	"

FILES_libmono-webserver1.0-cil-dbg += " \
	/usr/lib/mono/gac/Mono.WebServer/0.1.*/*.mdb \
	"
FILES_libmono-webserver1.0-cil = " \
	/usr/lib/mono/gac/Mono.WebServer/0.1.*/ \
	/usr/lib/mono/1.0/Mono.WebServer.dll \
	"
FILES_libmono-webserver2.0-cil-dbg += " \
	/usr/lib/mono/gac/Mono.WebServer2/0.2.*/*.mdb \
	"
FILES_libmono-webserver2.0-cil = " \
	/usr/lib/mono/gac/Mono.WebServer2/0.2.*/ \
	/usr/lib/mono/2.0/Mono.WebServer2.dll \
	"
FILES_${PN}-dbg += " \
	/usr/lib/mono/gac/xsp/1.2.*/*.mdb \
	"
FILES_${PN} = " \
	/usr/lib/mono/gac/xsp/1.2.*/ \
	/usr/lib/mono/1.0/xsp.exe \
	/usr/bin/xsp \
	/usr/bin/asp-state \
	/usr/bin/dbsessmgr \
	/usr/lib/xsp/1.0/asp-state.exe.config \
	/usr/lib/xsp/1.0/asp-state.exe \
	/usr/lib/xsp/1.0/dbsessmgr.exe.config \
	/usr/lib/xsp/1.0/dbsessmgr.exe \
	"
FILES_mono-xsp2-dbg += " \
	/usr/lib/mono/gac/xsp2/1.2.*/*.dbg \
	"
FILES_mono-xsp2 = " \
	/usr/lib/mono/gac/xsp2/1.2.*/ \
	/usr/lib/mono/2.0/xsp2.exe \
	/usr/bin/xsp2 \
	/usr/bin/asp-state2 \
	/usr/bin/dbsessmgr2 \
	/usr/lib/xsp/2.0/asp-state2.exe.config \
	/usr/lib/xsp/2.0/asp-state2.exe \
	/usr/lib/xsp/2.0/dbsessmgr2.exe.config \
	/usr/lib/xsp/2.0/dbsessmgr2.exe \
	"
FILES_mono-mod-mono-server-dbg += "\
	/usr/lib/mono/gac/mod-mono-server/1.2.*/*.mdb \
	"
FILES_mono-mod-mono-server = "\
	/usr/lib/mono/gac/mod-mono-server/1.2.*/ \
	/usr/lib/mono/1.0/mod-mono-server.exe \
	/usr/bin/mod-mono-server \
	"
FILES_mono-mod-mono-server2-dbg += "\
	/usr/lib/mono/gac/mod-mono-server2/1.2.*/*.mdb \
	"
FILES_mono-mod-mono-server2 = "\
	/usr/lib/mono/gac/mod-mono-server2/1.2.*/ \
	/usr/lib/mono/2.0/mod-mono-server2.exe \
	/usr/bin/mod-mono-server2 \
	"
FILES_mono-xsp-dev = "\
	/usr/lib/pkgconfig/xsp.pc \
	/usr/lib/pkgconfig/xsp-2.pc \
	"
FILES_mono-xsp-test = " \
	/usr/lib/xsp/test/1.1/authtest/index.aspx \
	/usr/lib/xsp/test/1.1/authtest/login.aspx \
	/usr/lib/xsp/test/1.1/authtest/web.config \
	/usr/lib/xsp/test/1.1/asp.net/browsercaps.aspx \
	/usr/lib/xsp/test/1.1/asp.net/codebehind1.aspx \
	/usr/lib/xsp/test/1.1/asp.net/code-render.aspx \
	/usr/lib/xsp/test/1.1/asp.net/body.inc \
	/usr/lib/xsp/test/1.1/asp.net/header.inc \
	/usr/lib/xsp/test/1.1/asp.net/registertest1.ascx \
	/usr/lib/xsp/test/1.1/asp.net/registertest2.ascx \
	/usr/lib/xsp/test/1.1/asp.net/includetest.aspx \
	/usr/lib/xsp/test/1.1/asp.net/registertest.aspx \
	/usr/lib/xsp/test/1.1/asp.net/server-side-object.aspx \
	/usr/lib/xsp/test/1.1/asp.net/session1.aspx \
	/usr/lib/xsp/test/1.1/asp.net/typedesc.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/listitem.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/temperature.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/validator1.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_adrotator.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_button.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_checkbox.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_checkboxlist.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_datagrid.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_datagrid_command.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_dropdownlist.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_hyperlink.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_image.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_imagebutton.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_label.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_linkbutton.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_listbox.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_literal.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_panel.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_placeholder.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_radiobutton.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_radiobuttonlist.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_regularexpressionvalidator.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_repeater.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_table2.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_table.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_textbox.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/web_xml.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/calendar.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/datalist.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/dbpage1.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/dbpage2.aspx \
	/usr/lib/xsp/test/1.1/webcontrols/people.xml \
	/usr/lib/xsp/test/1.1/webcontrols/web_adrotator.xml \
	/usr/lib/xsp/test/1.1/webcontrols/peopletable.xsl \
	/usr/lib/xsp/test/1.1/html/button.aspx \
	/usr/lib/xsp/test/1.1/html/htmlanchor.aspx \
	/usr/lib/xsp/test/1.1/html/htmlbutton.aspx \
	/usr/lib/xsp/test/1.1/html/htmlgeneric.aspx \
	/usr/lib/xsp/test/1.1/html/htmlimage.aspx \
	/usr/lib/xsp/test/1.1/html/htmlinputbutton.aspx \
	/usr/lib/xsp/test/1.1/html/htmlinputcheckbox.aspx \
	/usr/lib/xsp/test/1.1/html/htmlinputfile.aspx \
	/usr/lib/xsp/test/1.1/html/htmlinputhidden.aspx \
	/usr/lib/xsp/test/1.1/html/htmlinputimage.aspx \
	/usr/lib/xsp/test/1.1/html/htmlinputradiobutton.aspx \
	/usr/lib/xsp/test/1.1/html/htmlinputtext.aspx \
	/usr/lib/xsp/test/1.1/html/htmlselect.aspx \
	/usr/lib/xsp/test/1.1/html/htmltable.aspx \
	/usr/lib/xsp/test/1.1/html/htmltextarea.aspx \
	/usr/lib/xsp/test/1.1/webservice/ConverterService.asmx \
	/usr/lib/xsp/test/1.1/webservice/TestService.asmx \
	/usr/lib/xsp/test/1.1/webservice/ServiceClient.exe.config \
	/usr/lib/xsp/test/1.1/webservice/CompressExtension.cs \
	/usr/lib/xsp/test/1.1/databind/databind-arraylist.aspx \
	/usr/lib/xsp/test/1.1/databind/databind-attribute.aspx \
	/usr/lib/xsp/test/1.1/databind/databind-class.aspx \
	/usr/lib/xsp/test/1.1/databind/databind-template.aspx \
	/usr/lib/xsp/test/1.1/handlers/chunked.ashx \
	/usr/lib/xsp/test/1.1/handlers/empty.ashx \
	/usr/lib/xsp/test/1.1/handlers/monodoc.ashx \
	/usr/lib/xsp/test/1.1/handlers/webhandler.ashx \
	/usr/lib/xsp/test/1.1/handlers/async.ashx \
	/usr/lib/xsp/test/1.1/customcontrol/tabcontrol2.aspx \
	/usr/lib/xsp/test/1.1/customcontrol/tabcontrol.aspx \
	/usr/lib/xsp/test/ServiceClient.exe \
	/usr/lib/xsp/test/extensions.dll \
	/usr/lib/xsp/test/mod-mono-server.exe.config \
	/usr/lib/xsp/test/index.aspx \
	/usr/lib/xsp/test/index2.aspx \
	/usr/lib/xsp/test/xsp.exe.config \
	/usr/lib/xsp/test/web.config \
	/usr/lib/xsp/test/global.asax \
	/usr/lib/xsp/test/mono.png \
	/usr/lib/xsp/test/monobutton.png \
	/usr/lib/xsp/test/mono-powered-big.png \
	/usr/lib/xsp/test/small-icon.png \
	/usr/lib/xsp/test/sample.webapp \
	/usr/lib/xsp/test/favicon.ico \
	/usr/lib/xsp/test/mono-xsp.css \
	/usr/lib/xsp/test/bin/codebehind1.dll \
	/usr/lib/xsp/test/bin/typedesc.dll \
	/usr/lib/xsp/test/bin/extensions.dll \
	/usr/lib/xsp/test/bin/tabcontrol.dll \
	/usr/lib/xsp/test/bin/tabcontrol2.dll \
	/usr/lib/xsp/test/bin/treeview.dll \
	/usr/lib/xsp/test/2.0/menu/menu1.aspx \
	/usr/lib/xsp/test/2.0/menu/menu2.aspx \
	/usr/lib/xsp/test/2.0/menu/stock_copy_24.png \
	/usr/lib/xsp/test/2.0/menu/stock_cut_24.png \
	/usr/lib/xsp/test/2.0/menu/stock_paste_24.png \
	/usr/lib/xsp/test/2.0/treeview/populate-on-demand.aspx \
	/usr/lib/xsp/test/2.0/treeview/populate.cs \
	/usr/lib/xsp/test/2.0/treeview/treeview.aspx \
	/usr/lib/xsp/test/2.0/treeview/treeview-databound.aspx \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/dash.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/dashminus.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/dashplus.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/i.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/l.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/lminus.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/lplus.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/minus.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/noexpand.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/plus.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/r.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/rminus.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/rplus.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/t.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/tminus.gif \
	/usr/lib/xsp/test/2.0/treeview/TreeLineImages/tplus.gif \
	/usr/lib/xsp/test/2.0/masterpages/simple.master \
	/usr/lib/xsp/test/2.0/masterpages/simple.aspx \
	/usr/lib/xsp/test/2.0/masterpages/frame.master \
	/usr/lib/xsp/test/2.0/masterpages/content1.aspx \
	/usr/lib/xsp/test/2.0/masterpages/content2.aspx \
	"


