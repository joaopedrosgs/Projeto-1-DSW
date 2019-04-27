var deleteButtons = document.getElementsByClassName('delete');

for (var i = 0; i < deleteButtons.length; i++) {
    deleteButtons[i].addEventListener('click', dismiss);
}

function dismiss(e) {
    this.parentNode.classList.add('is-hidden');
}