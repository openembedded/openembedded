from testresult import TestItem, TestResult
from testreport_text import TestReportText
from testreport_html import TestReportHTML
from testreport_tinder import TestReportTinder
from config import parse_test_options

import sys, os, optparse
import bb
import bb.data
import bb.parse


__all__ = [
    "TestResult",
    "TestItem",
    "TestReportText",
    "TestReportHTML",
    "TestReportTinder",

# fileparser.py
    "fileparser",
# config.py
    "parse_test_options",

# in this file
    "__version__",
    "__all_tests__",
    "__all_reports__",
    "handle_options",
    "_load_config",
    "_get_instances",
    "generate_results",
    "run_tests"
   
]


__version__   = 0.2

# Add your test here
__all_tests__ = ["patch_checker",
                 "source_checker",
                 "doc_checker",
                 "content_checker",
                 "depends_checker" ]

# known reporting classes
__all_reports__ = {
    "TestReportText" : TestReportText,
    "TestReportHTML" : TestReportHTML,
    "TestReportTinder" : TestReportTinder
}



def handle_options( args ):
    """
    Handle the options and return the handled options and the rest (not parsed)
    """
    parser = optparse.OptionParser( version = "BitTest Bitbake Testing Tool version %s" % __version__,
                                    usage = """%prog [options] [test ...]
Executes the specified tests or if none are given all tests. The result is printed
on the cmd line
""" )

    parser.add_option( "-o", "--output", help = "print the output to the file",
                       action = "store", dest = "output", default  = sys.stdout )
    parser.add_option( "-r", "--report", help = "print the report in the specified format",
                       action = "store", dest = "report", default = "TestReportText" )

    options, args = parser.parse_args( args )

    if not options.report in __all_reports__:
        print "The specified report format is not available. Falling back to TestReportText"
        options.report = "TestReportText"

    if not type(options.output) == type(sys.stdout):
        """ Create a file """
        options.output = file(options.output, "w")

    return options, args[1:]


def _load_config(file):
    """
    load a config file into a bb.data instance
    """
    try:
        return bb.parse.handle(os.path.join('conf', file), bb.data.init() )
    except IOError, e:
        return None


def _get_instances(tests):
    test_inst = {}

    # create instances
    for test in tests:
        test_inst[test] = __import__(test).create_test()

    return test_inst


def generate_results(test_results, options):
    for result in test_results:
        res = test_results[result]
        res.test_reporter().init(res)
        res.test_reporter().print_result()


def run_tests(data,test_config,test_options, tests,  options):
    """
    Run tests using 'data' as base
    """
    
    bbfiles = fileparser.find_files(bb.data.getVar('BBFILES', test_config).split(' '))
    bb.note("Collected %d BitBake files" % len(bbfiles) )

    tmp_dir = os.path.join(os.getcwd(),'tmp')
    src_dir = os.path.join(os.getcwd(),'tmp_sources')
    bb.mkdirhier(tmp_dir)
    bb.mkdirhier(src_dir)

    # now run the tests for each test
    test_results   = {}
    test_instances = _get_instances(tests)

    # Create the TestResult container and initialize the Report
    for test in test_instances:
        test_results[test] = TestResult(test_instances[test].test_name(), __all_reports__[options.report](test_config, test, options.output) )

    for bbfile in bbfiles:

        # now we do it for each configuration...
        for (arch,os1,distro,machines) in test_options:
            test_data = bb.data.createCopy(data)
            bb.data.setVar('TARGET_ARCH', arch, test_data)
            bb.data.setVar('TARGET_OS',   os1,  test_data)
            bb.data.setVar('DISTRO',    distro, test_data)

            # include the distro
            bb.parse.handle(os.path.join('conf/distro',distro+'.conf'),test_data,1)

            # now for each machine and we can finally run the tests
            for machine in machines:
                machine_data = bb.data.createCopy(test_data)
                bb.data.setVar('MACHINE', machine, machine_data)

                try:
                    bb.parse.handle(os.path.join('conf/machine',machine+'.conf'),machine_data,1)
                except:
                    bb.note("Machine %s is not known" % machine)

                try:
                    bb_data = bb.parse.handle(bbfile, bb.data.createCopy(machine_data))
                except bb.parse.SkipPackage:
                    bb.note("Skipping Package %s" % bbfile)
                    continue
                except Exception, e:
                    bb.note("Error on parsing: %s:%s" % (bbfile, e))
                    continue

                # run the testcases now
                for test in test_instances:
                    test_run = bb.data.createCopy(bb_data)

                    # be sure these variables are set
                    bb.data.setVar('TMPDIR', tmp_dir, test_run)
                    bb.data.setVar('DL_DIR', src_dir, test_run)


                    bb.data.update_data(test_run)
#                    print "Running test for %s with machine: %s and distro: %s" % (bb.data.getVar('PN', test_run, True), machine, distro)
                    test_results[test].insert_result(test_instances[test].test(bbfile, test_run))

    return test_results
