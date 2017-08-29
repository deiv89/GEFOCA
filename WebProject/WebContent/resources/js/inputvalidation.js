var file = document.getElementById('my-file');

file.onchange = function(e){
    var ext = this.value.match(/\.([^\.]+)$/)[1];
    switch(ext)
    {
        case 'pdf':
        case 'doc':
        case 'docx':
            alert('allowed');
            break;
        default:
            alert('not allowed');
            this.value='';
    }
};
