package com.nezami.parstasmimtestproject.ui.home;

import androidx.recyclerview.widget.RecyclerView;

import com.nezami.parstasmimtestproject.data.model.Book;
import com.nezami.parstasmimtestproject.databinding.ItemBooksBinding;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
public class BooksViewHolder extends RecyclerView.ViewHolder {

    private ItemBooksBinding binding;

    public BooksViewHolder(ItemBooksBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }


    public void bind(Book book, BooksAdapter.OnItemClickListener onItemClickListener) {
//        binding.txtTitle.setText(book.getTitle());
//        binding.txtAuthorName.setText(book.getAuthor());
//        binding.txtGenre.setText(book.getGenre());
//        binding.txtYear.setText(String.valueOf(book.getYearPublished()));
        binding.setBook(book);
        binding.getRoot().setOnClickListener(view -> onItemClickListener.onClick(book));
    }
}
