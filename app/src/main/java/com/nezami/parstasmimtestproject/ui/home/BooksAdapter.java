package com.nezami.parstasmimtestproject.ui.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nezami.parstasmimtestproject.data.model.Book;
import com.nezami.parstasmimtestproject.databinding.ItemBooksBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alireza Nezami on 10/18/2021.
 */
public class BooksAdapter extends RecyclerView.Adapter<BooksViewHolder> {

    private OnItemClickListener onItemClickListener;
    private List<Book> books = new ArrayList<>();

    public void updateData(List<Book> books) {
        this.books.clear();
        this.books.addAll(books);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BooksViewHolder(ItemBooksBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        holder.bind(getItem(position), onItemClickListener);
    }

    private Book getItem(int position) {
        return books.get(position);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setonItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void update(Book book) {
        if (book.deleted) {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).id.equals(book.id)) {
                    books.remove(i);
                    notifyItemChanged(i);
                    return;
                }
            }
        } else {
            books.add(0, book);
            notifyItemChanged(0);
        }
    }

    public interface OnItemClickListener {
        void onClick(Book book);
    }
}
