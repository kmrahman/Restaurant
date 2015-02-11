/**
 * Created by Sabid on 1/28/2015.
 */

(function(){
    $( '#dropNew' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#new_edit').css('display', 'inline');

    });
    $( '#dropEdit' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#editReserve').css('display', 'inline');

    });

    $( '#dropCancel' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#cancel').css('display', 'inline');

    });

    $( '#loginHeader' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#loginSection').css('display', 'inline');

    });
    $( '#dropReserve' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#reservationSection').css('display', 'inline');
    });


    $( '#dropSeating' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#seatingSection').css('display', 'inline');
    });


    $( '#dropProfile' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#profileSection').css('display', 'inline');
    });


    $( '#dropApp' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#appSettingsSection').css('display', 'inline');
    });


    $( '#dropContact' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#contactsSection').css('display', 'inline');
    });


    $( '#contactUs' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#contactUsSection').css('display', 'inline');
    });


    $( '#menuBtn' ).on( 'click', function(event) {
        //this refers to the element
        $('#imageSection').css('display', 'none');
        $('.sectionProp').css('display', 'none');
        $('#menuSection').css('display', 'inline');
    });


})(jQuery);