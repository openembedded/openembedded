# This is a generated file, please do not edit directly
# Use collect-paths.py instead. -- Henryk <henryk@openmoko.org>
debian_mono_file_table = [
	{	'name': 'mono-jit',
		'patterns': [
				'/usr/bin/mono'
			]
	},
	{	'name': 'mono-gac',
		'patterns': [
				'/usr/bin/gacutil',
				'/usr/lib/mono/1.0/gacutil.exe'
			]
	},
	{	'name': 'mono-mjs',
		'patterns': [
				'/usr/bin/mjs',
				'/usr/lib/mono/1.0/mjs.exe*'
			]
	},
	{	'name': 'mono-gmcs',
		'patterns': [
				'/usr/bin/gmcs',
				'/usr/bin/wsdl2',
				'/usr/bin/monop2',
				'/usr/bin/ilasm2',
				'/usr/bin/resgen2',
				'/usr/bin/mono-api-info2',
				'/usr/bin/mono-service2',
				'/usr/bin/mkbundle2',
				'/usr/bin/xbuild',
				'/usr/bin/sgen',
				'/usr/bin/al2',
				'/usr/bin/httpcfg',
				'/usr/lib/mono/2.0/*.exe*',
				'/usr/lib/mono/2.0/xbuild.rsp',
				'/usr/lib/mono/2.0/MSBuild/',
				'/usr/lib/mono/2.0/Microsoft.Build.xsd',
				'/usr/lib/mono/2.0/Microsoft.CSharp.targets',
				'/usr/lib/mono/2.0/Microsoft.Common.tasks',
				'/usr/lib/mono/2.0/Microsoft.Common.targets',
				'/usr/lib/mono/2.0/Microsoft.VisualBasic.targets'
			]
	},
	{	'name': 'mono-utils',
		'patterns': [
				'/usr/bin/pedump',
				'/usr/bin/monodis',
				'/usr/bin/monograph',
				'/usr/bin/mono-find-provides',
				'/usr/bin/mono-find-requires'
			]
	},
	{	'name': 'libmono-peapi1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/PEAPI/1.0.*/',
				'/usr/lib/mono/1.0/PEAPI.dll'
			],
		'assemblies': [
				('PEAPI', '1.0.*')
			]
	},
	{	'name': 'libmono-cairo1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.Cairo/1.0.*/',
				'/usr/lib/mono/1.0/Mono.Cairo.dll',
				'/usr/lib/pkgconfig/mono-cairo.pc'
			],
		'assemblies': [
				('Mono.Cairo', '1.0.*')
			]
	},
	{	'name': 'libmono-system-web2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Web/2.0.*/',
				'/usr/lib/mono/gac/System.Web.Services/2.0.*/',
				'/usr/lib/mono/2.0/System.Web.dll',
				'/usr/lib/mono/2.0/System.Web.Services.dll'
			],
		'assemblies': [
				('System.Web', '2.0.*'),
				('System.Web.Services', '2.0.*')
			]
	},
	{	'name': 'libmono-accessibility2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Accessibility/2.0.*/',
				'/usr/lib/mono/2.0/Accessibility.dll'
			],
		'assemblies': [
				('Accessibility', '2.0.*')
			]
	},
	{	'name': 'libmono-microsoft7.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Microsoft.JScript/7.0.*/',
				'/usr/lib/mono/gac/Microsoft.VisualC/7.0.*/',
				'/usr/lib/mono/gac/Microsoft.Vsa/7.0.*/',
				'/usr/lib/mono/1.0/Microsoft.JScript.dll',
				'/usr/lib/mono/1.0/Microsoft.VisualC.dll',
				'/usr/lib/mono/1.0/Microsoft.Vsa.dll'
			],
		'assemblies': [
				('Microsoft.JScript', '7.0.*'),
				('Microsoft.VisualC', '7.0.*'),
				('Microsoft.Vsa', '7.0.*')
			]
	},
	{	'name': 'libmono-winforms2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Windows.Forms/2.0.*/',
				'/usr/lib/mono/gac/System.Drawing.Design/2.0.*/',
				'/usr/lib/mono/gac/System.Design/2.0.*/',
				'/usr/lib/mono/2.0/System.Windows.Forms.dll',
				'/usr/lib/mono/2.0/System.Drawing.Design.dll',
				'/usr/lib/mono/2.0/System.Design.dll'
			],
		'assemblies': [
				('System.Windows.Forms', '2.0.*'),
				('System.Drawing.Design', '2.0.*'),
				('System.Design', '2.0.*')
			]
	},
	{	'name': 'libmono-ldap1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Novell.Directory.Ldap/1.0.*/',
				'/usr/lib/mono/1.0/Novell.Directory.Ldap.dll'
			],
		'assemblies': [
				('Novell.Directory.Ldap', '1.0.*')
			]
	},
	{	'name': 'libmono-sharpzip2.84-cil',
		'patterns': [
				'/usr/lib/mono/gac/ICSharpCode.SharpZipLib/2.84.*/',
				'/usr/lib/mono/2.0/ICSharpCode.SharpZipLib.dll'
			],
		'assemblies': [
				('ICSharpCode.SharpZipLib', '2.84.*')
			]
	},
	{	'name': 'libmono-system-data2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Data/2.0.*/',
				'/usr/lib/mono/2.0/System.Data.dll'
			],
		'assemblies': [
				('System.Data', '2.0.*')
			]
	},
	{	'name': 'libmono-corlib2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/I18N*/2.0.*/',
				'/usr/lib/mono/2.0/I18N*.dll',
				'/usr/lib/mono/2.0/mscorlib.dll*'
			],
		'assemblies': [
				('I18N*', '2.0.*'),
				('mscorlib', '2.0.*')
			]
	},
	{	'name': 'libmono-winforms1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Windows.Forms/1.0.*/',
				'/usr/lib/mono/gac/System.Drawing.Design/1.0.*/',
				'/usr/lib/mono/gac/System.Design/1.0.*/',
				'/usr/lib/mono/1.0/System.Windows.Forms.dll',
				'/usr/lib/mono/1.0/System.Drawing.Design.dll',
				'/usr/lib/mono/1.0/System.Design.dll'
			],
		'assemblies': [
				('System.Windows.Forms', '1.0.*'),
				('System.Drawing.Design', '1.0.*'),
				('System.Design', '1.0.*')
			]
	},
	{	'name': 'libmono-microsoft8.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Microsoft.JScript/8.0.*/',
				'/usr/lib/mono/gac/Microsoft.VisualC/8.0.*/',
				'/usr/lib/mono/gac/Microsoft.Vsa/8.0.*/',
				'/usr/lib/mono/2.0/Microsoft.JScript.dll',
				'/usr/lib/mono/2.0/Microsoft.VisualC.dll',
				'/usr/lib/mono/2.0/Microsoft.Vsa.dll'
			],
		'assemblies': [
				('Microsoft.JScript', '8.0.*'),
				('Microsoft.VisualC', '8.0.*'),
				('Microsoft.Vsa', '8.0.*')
			]
	},
	{	'name': 'libmono-corlib1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/I18N*/1.0.*/',
				'/usr/lib/mono/1.0/I18N*.dll',
				'/usr/lib/mono/1.0/mscorlib.dll*'
			],
		'assemblies': [
				('I18N*', '1.0.*'),
				('mscorlib', '1.0.*')
			]
	},
	{	'name': 'libmono-system-web1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Web/1.0.*/',
				'/usr/lib/mono/gac/System.Web.Services/1.0.*/',
				'/usr/lib/mono/1.0/System.Web.dll',
				'/usr/lib/mono/1.0/System.Web.Services.dll'
			],
		'assemblies': [
				('System.Web', '1.0.*'),
				('System.Web.Services', '1.0.*')
			]
	},
	{	'name': 'libmono-system-runtime2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Runtime.*/2.0.*/',
				'/usr/lib/mono/2.0/System.Runtime.*.dll'
			],
		'assemblies': [
				('System.Runtime.*', '2.0.*')
			]
	},
	{	'name': 'libmono-cscompmgd8.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/cscompmgd/8.0.*/',
				'/usr/lib/mono/2.0/cscompmgd.dll'
			],
		'assemblies': [
				('cscompmgd', '8.0.*')
			]
	},
	{	'name': 'libmono-cscompmgd7.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/cscompmgd/7.0.*/',
				'/usr/lib/mono/1.0/cscompmgd.dll'
			],
		'assemblies': [
				('cscompmgd', '7.0.*')
			]
	},
	{	'name': 'libmono-firebirdsql1.7-cil',
		'patterns': [
				'/usr/lib/mono/gac/FirebirdSql.Data.Firebird/1.7.*/',
				'/usr/lib/mono/1.0/FirebirdSql.Data.Firebird.dll'
			],
		'assemblies': [
				('FirebirdSql.Data.Firebird', '1.7.*')
			]
	},
	{	'name': 'mono-jay',
		'patterns': [
				'/usr/bin/jay'
			]
	},
	{	'name': 'libmono-data-tds1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.Data.Tds/1.0.*/',
				'/usr/lib/mono/1.0/Mono.Data.Tds.dll'
			],
		'assemblies': [
				('Mono.Data.Tds', '1.0.*')
			]
	},
	{	'name': 'libmono-sqlite1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.Data.Sqlite/1.0.*/',
				'/usr/lib/mono/gac/Mono.Data.SqliteClient/1.0.*/',
				'/usr/lib/mono/1.0/Mono.Data.Sqlite.dll',
				'/usr/lib/mono/1.0/Mono.Data.SqliteClient.dll'
			],
		'assemblies': [
				('Mono.Data.Sqlite', '1.0.*'),
				('Mono.Data.SqliteClient', '1.0.*')
			]
	},
	{	'name': 'libmono-relaxng1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Commons.Xml.Relaxng/1.0.*/',
				'/usr/lib/mono/1.0/Commons.Xml.Relaxng.dll'
			],
		'assemblies': [
				('Commons.Xml.Relaxng', '1.0.*')
			]
	},
	{	'name': 'libmono-dev',
		'patterns': [
				'/usr/lib/libmono*.a',
				'/usr/lib/libMono*.a',
				'/usr/lib/libmono*.so',
				'/usr/lib/libMonoSupportW.a',
				'/usr/lib/pkgconfig/mono.pc',
				'/usr/lib/pkgconfig/dotnet.pc',
				'/usr/include/'
			]
	},
	{	'name': 'libmono-accessibility1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Accessibility/1.0.*/',
				'/usr/lib/mono/1.0/Accessibility.dll'
			],
		'assemblies': [
				('Accessibility', '1.0.*')
			]
	},
	{	'name': 'mono-common',
		'patterns': [
				'/etc/mono',
				'/usr/share/mono-1.0/mono/cil/cil-opcodes.xml'
			]
	},
	{	'name': 'libmono-oracle1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Data.OracleClient/1.0.*/',
				'/usr/lib/mono/1.0/System.Data.OracleClient.dll'
			],
		'assemblies': [
				('System.Data.OracleClient', '1.0.*')
			]
	},
	{	'name': 'libmono-system-data1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Data/1.0.*/',
				'/usr/lib/mono/1.0/System.Data.dll'
			],
		'assemblies': [
				('System.Data', '1.0.*')
			]
	},
	{	'name': 'libmono-bytefx0.7.6.2-cil',
		'patterns': [
				'/usr/lib/mono/gac/ByteFX.Data/0.7.6.2*/',
				'/usr/lib/mono/2.0/ByteFX.Data.dll'
			],
		'assemblies': [
				('ByteFX.Data', '0.7.6.2*')
			]
	},
	{	'name': 'libmono0',
		'patterns': [
				'/usr/lib/libmono*.so.*',
				'/usr/lib/libMonoPosixHelper.so',
				'/usr/lib/libMonoSupportW.so'
			]
	},
	{	'name': 'libmono-sharpzip0.6-cil',
		'patterns': [
				'/usr/lib/mono/gac/ICSharpCode.SharpZipLib/0.6.*/',
				'/usr/lib/mono/compat-1.0/ICSharpCode.SharpZipLib.dll'
			],
		'assemblies': [
				('ICSharpCode.SharpZipLib', '0.6.*')
			]
	},
	{	'name': 'libmono-data-tds2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.Data.Tds/2.0.*/',
				'/usr/lib/mono/2.0/Mono.Data.Tds.dll'
			],
		'assemblies': [
				('Mono.Data.Tds', '2.0.*')
			]
	},
	{	'name': 'libmono-system-messaging1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Messaging/1.0.*/',
				'/usr/lib/mono/1.0/System.Messaging.dll'
			],
		'assemblies': [
				('System.Messaging', '1.0.*')
			]
	},
	{	'name': 'libmono-npgsql1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Npgsql/1.0.*/',
				'/usr/lib/mono/1.0/Npgsql.dll'
			],
		'assemblies': [
				('Npgsql', '1.0.*')
			]
	},
	{	'name': 'libmono-security2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.Security/2.0.*/',
				'/usr/lib/mono/2.0/Mono.Security.dll'
			],
		'assemblies': [
				('Mono.Security', '2.0.*')
			]
	},
	{	'name': 'libmono-security1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.Security/1.0.*/',
				'/usr/lib/mono/1.0/Mono.Security.dll'
			],
		'assemblies': [
				('Mono.Security', '1.0.*')
			]
	},
	{	'name': 'libmono-bytefx0.7.6.1-cil',
		'patterns': [
				'/usr/lib/mono/gac/ByteFX.Data/0.7.6.1*/',
				'/usr/lib/mono/1.0/ByteFX.Data.dll'
			],
		'assemblies': [
				('ByteFX.Data', '0.7.6.1*')
			]
	},
	{	'name': 'libmono-microsoft-build2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Microsoft.Build.*/2.0.*/',
				'/usr/lib/mono/2.0/Microsoft.Build.*.dll'
			],
		'assemblies': [
				('Microsoft.Build.*', '2.0.*')
			]
	},
	{	'name': 'libmono-system-ldap1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.DirectoryServices/1.0.*/',
				'/usr/lib/mono/1.0/System.DirectoryServices.dll'
			],
		'assemblies': [
				('System.DirectoryServices', '1.0.*')
			]
	},
	{	'name': 'libmono-relaxng2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Commons.Xml.Relaxng/2.0.*/',
				'/usr/lib/mono/2.0/Commons.Xml.Relaxng.dll'
			],
		'assemblies': [
				('Commons.Xml.Relaxng', '2.0.*')
			]
	},
	{	'name': 'libmono-system-ldap2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.DirectoryServices/2.0.*/',
				'/usr/lib/mono/2.0/System.DirectoryServices.dll'
			],
		'assemblies': [
				('System.DirectoryServices', '2.0.*')
			]
	},
	{	'name': 'libmono-system-messaging2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Messaging/2.0.*/',
				'/usr/lib/mono/2.0/System.Messaging.dll'
			],
		'assemblies': [
				('System.Messaging', '2.0.*')
			]
	},
	{	'name': 'libmono-sharpzip0.84-cil',
		'patterns': [
				'/usr/lib/mono/gac/ICSharpCode.SharpZipLib/0.84.*/',
				'/usr/lib/mono/1.0/ICSharpCode.SharpZipLib.dll'
			],
		'assemblies': [
				('ICSharpCode.SharpZipLib', '0.84.*')
			]
	},
	{	'name': 'libmono-sqlite2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.Data.Sqlite/2.0.*/',
				'/usr/lib/mono/gac/Mono.Data.SqliteClient/2.0.*/',
				'/usr/lib/mono/2.0/Mono.Data.Sqlite.dll',
				'/usr/lib/mono/2.0/Mono.Data.SqliteClient.dll'
			],
		'assemblies': [
				('Mono.Data.Sqlite', '2.0.*'),
				('Mono.Data.SqliteClient', '2.0.*')
			]
	},
	{	'name': 'libmono-ldap2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Novell.Directory.Ldap/2.0.*/',
				'/usr/lib/mono/2.0/Novell.Directory.Ldap.dll'
			],
		'assemblies': [
				('Novell.Directory.Ldap', '2.0.*')
			]
	},
	{	'name': 'libmono-npgsql2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Npgsql/2.0.*/',
				'/usr/lib/mono/2.0/Npgsql.dll'
			],
		'assemblies': [
				('Npgsql', '2.0.*')
			]
	},
	{	'name': 'libmono-system-runtime1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Runtime.*/1.0.*/',
				'/usr/lib/mono/1.0/System.Runtime.*.dll'
			],
		'assemblies': [
				('System.Runtime.*', '1.0.*')
			]
	},
	{	'name': 'libmono-oracle2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System.Data.OracleClient/2.0.*/',
				'/usr/lib/mono/2.0/System.Data.OracleClient.dll'
			],
		'assemblies': [
				('System.Data.OracleClient', '2.0.*')
			]
	},
	{	'name': 'libmono-c5-1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.C5/1.0.*/',
				'/usr/lib/mono/2.0/Mono.C5.dll'
			],
		'assemblies': [
				('Mono.C5', '1.0.*')
			]
	},
	{	'name': 'libmono-sharpzip2.6-cil',
		'patterns': [
				'/usr/lib/mono/gac/ICSharpCode.SharpZipLib/2.6.*/',
				'/usr/lib/mono/compat-2.0/ICSharpCode.SharpZipLib.dll'
			],
		'assemblies': [
				('ICSharpCode.SharpZipLib', '2.6.*')
			]
	},
	{	'name': 'libmono-cairo2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.Cairo/2.0.*/',
				'/usr/lib/mono/2.0/Mono.Cairo.dll'
			],
		'assemblies': [
				('Mono.Cairo', '2.0.*')
			]
	},
	{	'name': 'libmono-peapi2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/PEAPI/2.0.*/',
				'/usr/lib/mono/2.0/PEAPI.dll'
			],
		'assemblies': [
				('PEAPI', '2.0.*')
			]
	},
	{	'name': 'mono-mcs',
		'patterns': [
				'/usr/bin/',
				'/usr/lib/mono/1.0/*.exe*'
			]
	},
	{	'name': 'libmono-system1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System*/1.0.*/',
				'/usr/lib/mono/gac/CustomMarshalers/1.0.*/',
				'/usr/lib/mono/1.0/System*.dll',
				'/usr/lib/mono/1.0/CustomMarshalers.dll*'
			],
		'assemblies': [
				('System*', '1.0.*'),
				('CustomMarshalers', '1.0.*')
			]
	},
	{	'name': 'libmono-system2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/System*/2.0.*/',
				'/usr/lib/mono/gac/CustomMarshalers/2.0.*/',
				'/usr/lib/mono/2.0/System*.dll',
				'/usr/lib/mono/2.0/CustomMarshalers.dll*'
			],
		'assemblies': [
				('System*', '2.0.*'),
				('CustomMarshalers', '2.0.*')
			]
	},
	{	'name': 'libmono1.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.*/1.0.*/',
				'/usr/lib/mono/gac/OpenSystem.C/1.0.*',
				'/usr/lib/mono/gac/mono-service/1.0.*/',
				'/usr/lib/mono/1.0/Mono.*.dll',
				'/usr/lib/mono/1.0/OpenSystem.C.dll'
			],
		'assemblies': [
				('Mono.*', '1.0.*'),
				('OpenSystem.C', '1.0.*'),
				('mono-service', '1.0.*')
			]
	},
	{	'name': 'libmono2.0-cil',
		'patterns': [
				'/usr/lib/mono/gac/Mono.*/2.0.*/',
				'/usr/lib/mono/gac/OpenSystem.C/2.0.*',
				'/usr/lib/mono/gac/mono-service/2.0.*/',
				'/usr/lib/mono/2.0/Mono.*.dll',
				'/usr/lib/mono/2.0/OpenSystem.C.dll'
			],
		'assemblies': [
				('Mono.*', '2.0.*'),
				('OpenSystem.C', '2.0.*'),
				('mono-service', '2.0.*')
			]
	}
]
